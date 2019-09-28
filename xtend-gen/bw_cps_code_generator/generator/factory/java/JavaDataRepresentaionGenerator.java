package bw_cps_code_generator.generator.factory.java;

import bw_cps_code_generator.generator.GenerationUtil;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import dataRepresentation.Data;
import dataRepresentation.DataSet;
import dataRepresentation.DataType;
import dataRepresentation.LinearDataConversionWithInterval;
import dataRepresentation.ListData;
import dataRepresentation.MeasurementData;
import dataRepresentation.NonMeasurementData;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class JavaDataRepresentaionGenerator {
  private static final String LONG_FORMATTED = "l";
  
  private static final String FLOAT_FORMATTED = "f";
  
  private static final String DOUBLE_FORMATTED = ".0";
  
  /**
   * Generates the data fields for this data set including used data sets.
   */
  public CharSequence generateDataFields(final NamedElement e) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<NonMeasurementData> _filter = Iterables.<NonMeasurementData>filter(e.eContents(), NonMeasurementData.class);
      for(final NonMeasurementData data : _filter) {
        _builder.newLine();
        CharSequence _generateDataFields = this.generateDataFields(data);
        _builder.append(_generateDataFields);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Iterable<MeasurementData> _filter_1 = Iterables.<MeasurementData>filter(e.eContents(), MeasurementData.class);
      for(final MeasurementData data_1 : _filter_1) {
        CharSequence _generateDataFields_1 = this.generateDataFields(data_1);
        _builder.append(_generateDataFields_1);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Iterable<ListData> _filter_2 = Iterables.<ListData>filter(e.eContents(), ListData.class);
      for(final ListData data_2 : _filter_2) {
        CharSequence _generateDataFields_2 = this.generateDataFields(data_2);
        _builder.append(_generateDataFields_2);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateDataFields(final ListData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      String _description = data.getDescription();
      boolean _notEquals = (!Objects.equal(_description, null));
      if (_notEquals) {
        _builder.append("/* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* ");
        String _description_1 = data.getDescription();
        _builder.append(_description_1, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/ ");
        _builder.newLine();
      }
    }
    _builder.append("private List<");
    String _listType = this.getListType(data);
    _builder.append(_listType);
    _builder.append("> ");
    String _entityLowerName = GenerationUtil.getEntityLowerName(data);
    _builder.append(_entityLowerName);
    _builder.append(" = new ArrayList<");
    String _listType_1 = this.getListType(data);
    _builder.append(_listType_1);
    _builder.append(">();");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * Generates the fields for the measurement data
   */
  public CharSequence generateDataFields(final MeasurementData d) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    {
      String _description = d.getDescription();
      boolean _notEquals = (!Objects.equal(_description, null));
      if (_notEquals) {
        _builder.append(" ");
        _builder.append("* ");
        String _description_1 = d.getDescription();
        _builder.append(_description_1, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
      }
    }
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("private ");
    String _typeName = this.toTypeName(d);
    _builder.append(_typeName);
    _builder.append(" ");
    String _entityLowerName = GenerationUtil.getEntityLowerName(d);
    _builder.append(_entityLowerName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _hasLinearDataConversionWithInterval = this.hasLinearDataConversionWithInterval(d);
      if (_hasLinearDataConversionWithInterval) {
        _builder.append("/*");
        _builder.newLine();
        {
          String _description_2 = d.getDescription();
          boolean _notEquals_1 = (!Objects.equal(_description_2, null));
          if (_notEquals_1) {
            _builder.append(" * ");
            String _description_3 = d.getDescription();
            _builder.append(_description_3);
            _builder.newLineIfNotEmpty();
            _builder.append(" ");
            _builder.append("* ");
            _builder.newLine();
          }
        }
        _builder.append(" ");
        _builder.append("* Adjusted");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("private ");
        String _typeName_1 = this.toTypeName(this.getDataConversionType(d));
        _builder.append(_typeName_1);
        _builder.append(" ");
        String _entityLowerName_1 = GenerationUtil.getEntityLowerName(d);
        _builder.append(_entityLowerName_1);
        _builder.append("Adjusted;");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  /**
   * Generates the fields for the non measurement data
   */
  public CharSequence generateDataFields(final NonMeasurementData d) {
    CharSequence _xifexpression = null;
    boolean _isConstant = d.isConstant();
    if (_isConstant) {
      StringConcatenation _builder = new StringConcatenation();
      {
        String _description = d.getDescription();
        boolean _notEquals = (!Objects.equal(_description, null));
        if (_notEquals) {
          _builder.append("/*");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*");
          String _description_1 = d.getDescription();
          _builder.append(_description_1, " ");
          _builder.newLineIfNotEmpty();
          {
            boolean _isUnsigned = this.isUnsigned(d.getDataType());
            if (_isUnsigned) {
              _builder.append(" ");
              _builder.append("*");
              _builder.newLine();
              _builder.append(" ");
              _builder.append("* Java has no option for unsigned data types, so if the data has an ");
              _builder.newLine();
              _builder.append(" ");
              _builder.append("* unsigned data type the value is calculated by subtracting the maximum ");
              _builder.newLine();
              _builder.append(" ");
              _builder.append("* value from the signed data type and adding it again, if it is used.");
              _builder.newLine();
              _builder.append(" ");
              _builder.append("*");
              _builder.newLine();
            }
          }
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
        }
      }
      _builder.append("private ");
      String _typeName = this.toTypeName(d);
      _builder.append(_typeName);
      _builder.append(" ");
      String _upperCase = d.getName().toUpperCase();
      _builder.append(_upperCase);
      _builder.append(" = ");
      {
        boolean _isUnsigned_1 = this.isUnsigned(d.getDataType());
        if (_isUnsigned_1) {
          _builder.append("(");
          String _simpleTypeName = this.toSimpleTypeName(d);
          _builder.append(_simpleTypeName);
          _builder.append(") (");
          String _value = d.getValue();
          _builder.append(_value);
          _builder.append(" - ");
          String _typeName_1 = this.toTypeName(d);
          _builder.append(_typeName_1);
          _builder.append(".MAX_VALUE)");
        } else {
          {
            DataType _dataType = d.getDataType();
            boolean _equals = Objects.equal(_dataType, DataType.STRING);
            if (_equals) {
              String _value_1 = d.getValue();
              _builder.append(_value_1);
            } else {
              String _formatedValue = this.getFormatedValue(d);
              _builder.append(_formatedValue);
            }
          }
        }
      }
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        String _description_2 = d.getDescription();
        boolean _notEquals_1 = (!Objects.equal(_description_2, null));
        if (_notEquals_1) {
          _builder_1.append("/*");
          _builder_1.newLine();
          _builder_1.append(" ");
          _builder_1.append("*");
          String _description_3 = d.getDescription();
          _builder_1.append(_description_3, " ");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append(" ");
          _builder_1.append("*/");
          _builder_1.newLine();
        }
      }
      _builder_1.append("private ");
      String _typeName_2 = this.toTypeName(d);
      _builder_1.append(_typeName_2);
      _builder_1.append(" ");
      String _entityLowerName = GenerationUtil.getEntityLowerName(d);
      _builder_1.append(_entityLowerName);
      {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(d.getValue());
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder_1.append(" = ");
          {
            DataType _dataType_1 = d.getDataType();
            boolean _equals_1 = Objects.equal(_dataType_1, DataType.STRING);
            if (_equals_1) {
              String _value_2 = d.getValue();
              _builder_1.append(_value_2);
            } else {
              String _formatedValue_1 = this.getFormatedValue(d);
              _builder_1.append(_formatedValue_1);
            }
          }
        }
      }
      _builder_1.append(";");
      _builder_1.newLineIfNotEmpty();
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  private String getFormatedValue(final NonMeasurementData data) {
    String _xblockexpression = null;
    {
      String value = data.getValue();
      boolean _equals = this.toTypeName(data).equals(Long.class.getName());
      if (_equals) {
        String _value = value;
        value = (_value + JavaDataRepresentaionGenerator.LONG_FORMATTED);
      }
      boolean _equals_1 = this.toTypeName(data).equals(Float.class.getName());
      if (_equals_1) {
        String _value_1 = value;
        value = (_value_1 + JavaDataRepresentaionGenerator.FLOAT_FORMATTED);
      }
      boolean _equals_2 = this.toTypeName(data).equals(Double.class.getName());
      if (_equals_2) {
        String _value_2 = value;
        value = (_value_2 + JavaDataRepresentaionGenerator.DOUBLE_FORMATTED);
      }
      _xblockexpression = value;
    }
    return _xblockexpression;
  }
  
  /**
   * Maps to the corresponding language data type.
   * @see IDTOGenerator#toTypeName(Data)
   */
  public String toTypeName(final Data d) {
    return this.toTypeName(d.getDataType());
  }
  
  /**
   * return the type of the list
   */
  public String getListType(final ListData data) {
    DataType _dataType = data.getDataType();
    boolean _notEquals = (!Objects.equal(_dataType, DataType.UNDEFINED));
    if (_notEquals) {
      return this.toTypeName(data.getDataType());
    } else {
      DataSet _dataTypeDataSet = data.getDataTypeDataSet();
      boolean _notEquals_1 = (!Objects.equal(_dataTypeDataSet, null));
      if (_notEquals_1) {
        return data.getDataTypeDataSet().getName();
      }
    }
    return null;
  }
  
  /**
   * returns the appropriate type name for DataType
   */
  public String toTypeName(final DataType d) {
    String _switchResult = null;
    if (d != null) {
      switch (d) {
        case INT8:
          _switchResult = Byte.class.getName();
          break;
        case UINT8:
          _switchResult = Byte.class.getName();
          break;
        case INT16:
          _switchResult = Short.class.getName();
          break;
        case UINT16:
          _switchResult = Short.class.getName();
          break;
        case INT32:
          _switchResult = Integer.class.getName();
          break;
        case UINT32:
          _switchResult = Integer.class.getName();
          break;
        case INT64:
          _switchResult = Long.class.getName();
          break;
        case UINT64:
          _switchResult = Long.class.getName();
          break;
        case FLOAT:
          _switchResult = Float.class.getName();
          break;
        case DOUBLE:
          _switchResult = Double.class.getName();
          break;
        case BOOLEAN:
          _switchResult = Boolean.class.getName();
          break;
        case STRING:
          _switchResult = String.class.getName();
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  /**
   * returns the appropriate simple type name suitable for casting
   */
  public String toSimpleTypeName(final Data d) {
    return this.toSimpleTypeName(d.getDataType());
  }
  
  /**
   * returns the appropriate simple type name suitable for casting for dataType
   */
  public String toSimpleTypeName(final DataType d) {
    String _switchResult = null;
    if (d != null) {
      switch (d) {
        case INT8:
          _switchResult = "byte";
          break;
        case UINT8:
          _switchResult = "byte";
          break;
        case INT16:
          _switchResult = "short";
          break;
        case UINT16:
          _switchResult = "short";
          break;
        case INT32:
          _switchResult = "int";
          break;
        case UINT32:
          _switchResult = "int";
          break;
        case INT64:
          _switchResult = "long";
          break;
        case UINT64:
          _switchResult = "long";
          break;
        case FLOAT:
          _switchResult = "float";
          break;
        case DOUBLE:
          _switchResult = "double";
          break;
        case BOOLEAN:
          _switchResult = "boolean";
          break;
        case STRING:
          _switchResult = "String";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  /**
   * returns true if the DataType is an unsigned DataType
   */
  public boolean isUnsigned(final DataType d) {
    if ((((Objects.equal(d, DataType.UINT8) || Objects.equal(d, DataType.UINT16)) || Objects.equal(d, DataType.UINT32)) || Objects.equal(d, DataType.UINT64))) {
      return true;
    }
    return false;
  }
  
  /**
   * returns the Data Conversion type (at the moment
   * only LinearDataConversionWithIntervall has a type)
   */
  public DataType getDataConversionType(final MeasurementData d) {
    boolean _isEmpty = d.getAdjustments().isEmpty();
    if (_isEmpty) {
      return null;
    }
    Iterable<LinearDataConversionWithInterval> conversion = Iterables.<LinearDataConversionWithInterval>filter(d.getAdjustments(), LinearDataConversionWithInterval.class);
    if ((IterableExtensions.isEmpty(conversion) || Objects.equal(conversion, null))) {
      return null;
    }
    return IterableExtensions.<LinearDataConversionWithInterval>head(conversion).getDataType();
  }
  
  /**
   * @return true if the MeasurementData is adjusted
   * with linear data conversion with interval
   */
  public boolean hasLinearDataConversionWithInterval(final MeasurementData data) {
    boolean _isEmpty = IterableExtensions.isEmpty(Iterables.<LinearDataConversionWithInterval>filter(data.getAdjustments(), LinearDataConversionWithInterval.class));
    return (!_isEmpty);
  }
}
