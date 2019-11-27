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

### 7 Mandatory Objects
| Object Name | ID | Multiple Instances? | Description |
|---|---|:---:|---|
|LWM2M Security| 0 | Yes | This object provides key values and components necessary to acces a specified LWM2M server |
LwM2M Server | 1 | Yes | This object provides the data related to a LWM2M server |
Access Control | 2 | Yes | This object is used to check whether the LWM2M server has access rights for performing an operation.
Device | 3 | No | This object provides device related information which can be queried by the LWM2M server. It laso provides steps for device reboot and factory reset functions.
Connectivity Monitoring | 4 | No | This object enables parameter monitoring related to connectivity.
Firmware | 5 | No | This object includes steps on installing firmware packages, updating, and performing actions after firmware updates.
Location | 6 | No | Data related to GPS location of device.
Connectivity Statistics | 7 | No | This object enables client to collect telemetric stats and allows the LWM2M server to retrieve this information as well as the duration deadline and reset these parameters.

#### Object Example:
| Resource Name | ID | Access Type | Multiple Instances? | Type | Range | Units | Description |
|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
Latitude | 0 | R | No | Decimal | | Deg | Decimal notation of latitude under the _World Geodetic System 1984_. EX: **-43.5723**
Longitude | 1 | R | No | Decimal | | Deg | Decimal notation of longitude under the _World Geodetic System 1984_. EX: **153.21760**
Altitude | 2 | R | No | Decimal | | m | The number of altitude in meters above sea level
Uncertantity | 3 | R | No | Decimal |  | m | The accuracy of the position in meters.
Velocity | 4 | R | No | 3GPP GAD specs (_Not sure what this means_) | |3GPP GAD specs (_Not sure what this means_) | Velocity of the device as defined in 3GPP 23.032 GAD specification. This may not be available if device is static.
Timestamp | 5 | R | No | Time | | | Timestamp of when the location measurement was performed and updated
