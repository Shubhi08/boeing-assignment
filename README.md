# boeing-assignment
URL for the application : http://localhost:4200/flights
URL for the h2 DB : http://localhost:8080/springboot/h2/
# Hibernate ddl auto (create, create-drop, validate, update) - set this property to 'create' for first time DB creation using hibernate, then change it to 'update' to avoid data cleanup on every restart
spring.jpa.hibernate.ddl-auto = create 
Sample insert query to insert data into H2 DB : `insert into flight(id, actual_time, airline, estimate_time, flight_no, flight_type, source, destination, status) values (6, CURRENT_TIMESTAMP, 'Indigo', CURRENT_TIMESTAMP, '6E123', 'Outbound', 'Mumbai', 'Bangalore', 'Scheduled');`
