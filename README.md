# microservices-inside-jvm
Main idea is to run two independent artifacts inside one jvm (tomcat) and make one to talk to second without leaving 
that jvm.   

service-web - is a front controller

service-internal-web - internal service that should be accessible thru service-internal-client-..., where client can 
reach service with http or direct (with some kind of java magic)  

