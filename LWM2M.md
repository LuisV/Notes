# Lightweight Machine to Machine Protocol



## Overview
- Communication protocol by the [**_Open Mobile Alliance_**]( http://www.openmobilealliance.org/wp/OMNA/LwM2M/LwM2MRegistry.html "Protocol Specification")
- Used speficically for constrained application devices, only needs IP connectivity
- Can be used for device management as well as Application data
- Has object model that have to be registered with the OMNA

### Other Protocols
- **XMPP**
  - XML data based
- **MQTT**
  - TCP protocol
  - Supports websockets
- **OMA - DM** (Tradional Device Management)
  - Mainly used by phone networks to manage smart phones


Traditonally, professional architectures use a combination of OMA-DM with a data protocol.
# CoAP Protocol
- Inspired from HTTP but functions on UDP
- One to One communication with comfirable messages
- Has Similar HTTP verbs **(GET, POST, PUT, DELETE)**
- Also has:
  - **_Observe_**:
    - New data or state (complicated to do in HTTP)
    - GET + OBSERVE_ID
  - **_Discover_**:
    - Server has list of devices
  - Security: **DTLS**


# Back to LWM2M
## Technical details
- Client Server Model
- Operates on the CoAP(Constrained Application Protocol)
- Needs Client and Server implementations
- Has a variety of different actions
- Different interfaces to accomplish different things:
  - **Boostrap**
    - Cofigure Devices
    - Can be server or client initiated
  - **Registration**
    - Server registers client
    - Server also gets client resource count and saves them.

  - **Management**
    - Built in Management Objects
    - REST like API for managing applications
  - **Reporting**
    - Server can subscribe to events and changes in state

LWM2M has a defined object model:

The client has a collection of objects, and each object has a collection of Resources.

 ```
 _____________
|LWM2M Client
|    ________________
|   |Object 0
|   |    ___________
|   |   |Resource 1
|   |   |___________
|   |   |Resource 2
|   |   |___________
|   |_________________
|   __________________
|   |Object 1
|   | ....
```
Example: /12/1/4
**/**{_Object ID_}**/**{_Object Instance_}**/**{_Resource ID_}

12 = Device Object (Think of this like the Object Blueprint)
1 = Object Instance #1
4 = Manufacturer Resource #4
