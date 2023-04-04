@startuml
!theme crt-green
skinparam actorStyle awesome

actor "User" as usr

package Default {
 usecase "Add default objects" as AD
 usecase "Drop default objects" as DD
}

package Create {
 usecase "Create new Vendor" as CV
 usecase "Create new Client" as CC
 usecase "Create new Product" as CP
 usecase "Create new Order" as CO
}

package List {
 usecase "List All Objects" as LA
 usecase "List Vendors" as LV
 usecase "List Clients" as LC
 usecase "List Products" as LP
 usecase "List Orders" as LO
 usecase "List Products by Vendor" as LPV
 usecase "List Orders by Client" as LOC
}

package Edit {
 usecase "Edit Vendors" as EV
 usecase "Edit Clients" as EC
 usecase "Edit Products" as EP
 usecase "Edit Orders" as EO
}

usr --> AD
usr --> DD
usr --> CC
usr --> CV
usr --> CP
usr --> CO
usr --> LA
usr --> LV
usr --> LC
usr --> LP
usr --> LO
usr --> LPV
usr --> LOC
usr --> EV
usr --> EC
usr --> EP
usr --> EO

@enduml
