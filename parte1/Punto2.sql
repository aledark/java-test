/* DB AND TABLE DEFINITIONS FOR TESTS */

CREATE DATABASE IF NOT EXISTS concessionaireDB;

CREATE TABLE IF NOT EXISTS concessionaire(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS bus(
	id INT PRIMARY KEY AUTO_INCREMENT,
	type VARCHAR(50),
	motor VARCHAR(50),
	brakes VARCHAR(50),
	concessionaireId INT NOT NULL REFERENCES concessionaire(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS deviceType(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS device(
	id INT PRIMARY KEY AUTO_INCREMENT,
	ip VARCHAR(50),
	deviceTypeId INT REFERENCES deviceType(id) ON DELETE CASCADE,
	busId INT NOT NULL REFERENCES bus(id) ON DELETE CASCADE,
	status VARCHAR(10)
);

INSERT INTO concessionaire
VALUES (1, "Concessionaire 1"),(2, "Concessionaire 2"), (3, "Concessionaire 3");

INSERT INTO deviceType
VALUES (1, "CANBUS"),(2, "NVR");

INSERT INTO bus
VALUES	(1, "Bi-articulado", "Diesel", "Good",1),
		(2, "Bi-articulado", "Gas", "Regular",1),
		(3, "Bi-articulado", "Gas", "Good",1),
		(4, "Bi-articulado", "Electric", "Good",1),
		(5, "Articulado", "Hybrid", "Good",1),
		(6, "Bi-articulado", "Diesel", "Good",2),
		(7, "Articulado", "Hybrid", "Regular",2);

INSERT INTO device
VALUES	(1, "812.324.342", 2, 1,"Active"),
		(2, "353.456.243", 2, 1,"Inactive"),
		(3, "234.343.565", 2, 1,"Active"),
		(4, "232.456.768", 1, 2,"Inactive"),
		(5, "433.677.787", 2, 2,"Active"),
		(6, "132.345.023", 1, 2,"Inactive"),
		(7, "894.232.123", 2, 4,"Active"),
		(8, "345.655.232", 1, 1,"Inactive");
		
/* SQL SENTENCES */
/* a. Get all buses for Concessionaire 1 */

SELECT bus.* FROM bus JOIN concessionaire ON concessionaireId = concessionaire.id WHERE name = "Concessionaire 1";

/* b. Get all NVR devices for buses with type equal to "Bi-articulado" */

SELECT device.* FROM device JOIN bus ON device.busId = bus.id JOIN deviceType ON device.deviceTypeId = deviceType.id WHERE deviceType.name = "NVR" AND bus.type = "Bi-articulado";

/* c. Summarize the quantity of devices by status (Active / Inactive) and bus motor (Diesel / Gas / Electric / Hybrid) */

SELECT motor, status, COUNT(status) AS quantity FROM device JOIN bus ON device.busId = bus.id GROUP BY status, motor ORDER BY motor;



		
