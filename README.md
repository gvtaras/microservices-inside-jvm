# microservices-inside-jvm
Main idea is to run two independent artifacts inside one jvm (tomcat) and make one to talk to second without leaving 
that jvm.   

service-web - is a front controller

service-internal-web - internal service that should be accessible thru service-internal-client-..., where client can 
reach service with http or direct (with some kind of java magic)  

#### service-internal-client-jvm  
does not work (for now) because of different class loaders

#### service-internal-client-rmi 
does not work (for now) because there is too many changes in tomcat or/and SecurityManager needed for service-internal-web

#### service-internal-client-http  
not yet implemented

