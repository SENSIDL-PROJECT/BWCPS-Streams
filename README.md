![GitHub Workflow Status](https://img.shields.io/github/workflow/status/SENSIDL-PROJECT/BWCPS-Streams/Java%20CI)
![GitHub issues](https://img.shields.io/github/issues/SENSIDL-PROJECT/BWCPS-Streams)
![GitHub contributors](https://img.shields.io/github/contributors/SENSIDL-PROJECT/BWCPS-Streams)


# BW-CPS-Streams: Model-based Architectures for Secure Communication and Analytics in Edge Computing

Edge architectures favor distribution, which means that the computing and storing of data happen closer to where they are gathered or needed. Such systems can be integrated into existing, more conventional networks, and so for example they can allow a wide range of universal or highly specialized edge nodes to be installed between local sensors and cloud-based analysis systems in Industry 4.0 domains. 

Edge nodes can be any component or can be attached to any component (like local sensors, actuators, gateways) with their broadband and low latency capabilities. They aggregate, filter or analyze data streams and forward them. This enables the realization of robust, resilient systems that also support the protection of secrets and privacy through local processing. 

When edge nodes with their specific functionalities are used within sensor/actuator-systems with cloud connection, they form complex decentralized systems. To maintain the security goals, techniques for the reliable implementation of secure communication and data filtering/processing are necessary.

The BW-CPS project provides a framework with a domain-specific language for data stream modeling and analysis capabilities for secure edge properties.

# Repository Contents:

This repository contains the framework Stream Model for the description of edge architectures using a domain-specific modeling language. [Stream Model](https://github.com/SENSIDL-PROJECT/BWCPS-Streams/wiki/BWCPS-Stream-Model) includes the modeling language as well as [code generators](https://github.com/SENSIDL-PROJECT/BWCPS-Streams/tree/master/bundles/de.fzi.bwcps.generator) to create a prototype of the described architecture. Modeling is eased with the provided [Sirius-based graphical editor](https://github.com/SENSIDL-PROJECT/BWCPS-Streams/wiki/BWCPS-Sirius-Editor). Based on the [SensIDL](https://github.com/SENSIDL-PROJECT/SensIDL) framework for the model-based description of sensor interfaces and data structures for the communication, Stream Model enables the description of the entire bidirectional communication path from sensor to cloud. In addition to the [data processing functionalities](https://github.com/SENSIDL-PROJECT/BWCPS-Streams/wiki/BWCPS-Stream-Analysis) in the edge nodes, this includes security profiles that control security features such as [encryption and data signing](https://github.com/SENSIDL-PROJECT/BWCPS-Generator/blob/master/Documents/Security%20Aspects%20Integration.pdf) between and across edge nodes. 

> For more information please visit our [Wiki](https://github.com/SENSIDL-PROJECT/BWCPS-Streams/wiki).
- [Tutorial](../../wiki/BWCPS-Tutorial)
- [Stream Model](../../wiki/BWCPS-Stream-Model)
- [Generation Framework](../../wiki/BWCPS-Generation)
- [Stream Analysis](../../wiki/BWCPS-Stream-Analysis)

