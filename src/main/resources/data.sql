insert into employee (employee_id, first_name, last_name, email) values (1, 'John', 'Smith', 'JSmith@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (2, 'Bob', 'Jones', 'BobJ@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (3, 'Mike', 'Whitehouse', 'MikeW@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (4, 'Zoe', 'Smith', 'ZoeS@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (5, 'Elizabeth', 'Mahoney', 'ElizaM@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (6, 'Thomas', 'Brady', 'TBrady@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (7, 'Leo', 'Forrest', 'LeoForrest@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (8, 'Kirsten', 'Bond', 'KBond12@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (9, 'Brent', 'Rogers', 'BRogers@gmail.com');

-- INSERT PROJECTS			
insert into project (project_id, name, stage, description, start_date, end_date) values (1000, 'Banking System', 'NOTSTARTED', 'System to store account information and banking transactions', Date '2020-1-18', Date '2020-10-15');
insert into project (project_id, name, stage, description, start_date, end_date) values (1001, 'Traffic Monitoring System',  'COMPLETED', 'Implement system that monitors traffic congestion', Date '2020-2-15', Date '2020-3-15');
insert into project (project_id, name, stage, description, start_date, end_date) values (1002, 'Hospital Management System', 'COMPLETED', 'Handle medical, administrative, and financial workflow', Date '2020-1-24', Date '2020-7-25');
insert into project (project_id, name, stage, description, start_date, end_date) values (1003, 'Billing System', 'INPROGRESS', 'Implement Billing System to account for electriciy consumption', Date '2020-2-2', Date '2020-2-10');

-- INSERT PROJECT_EMPLOYEE_RELATION (Removed duplicates from video)
insert into project_employee (employee_id, project_id) values (1,1000);
insert into project_employee (employee_id, project_id) values (1,1001);
insert into project_employee (employee_id, project_id) values (1,1002);
insert into project_employee (employee_id, project_id) values (3,1000);
insert into project_employee (employee_id, project_id) values (6,1002);
insert into project_employee (employee_id, project_id) values (6,1003);