insert into employee (employee_id, first_name, last_name, email) values (1, 'Lebron', 'James', 'LBJ23@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (2, 'Stephon', 'Curry', 'StephCurry@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (3, 'Russell', 'Westbrook', 'RussWest@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (4, 'Kevin', 'Durant', 'KD7@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (5, 'Kobe', 'Bryant', 'KB24@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (6, 'Tom', 'Brady', 'TB12@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (7, 'Russell', 'Wilson', 'RWil@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (8, 'Peyton', 'Manning', 'PManning12@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (9, 'Aaron', 'Rogers', 'ARodge12@gmail.com');

-- INSERT PROJECTS			
insert into project (project_id, name, stage, description, start_date, end_date) values (1000, 'Win Championship', 'NOTSTARTED', 'Will require hard work', Date '2020-1-18', Date '2020-10-15');
insert into project (project_id, name, stage, description, start_date, end_date) values (1001, 'New Player Budget',  'COMPLETED', 'Determine how much money can be allocated for new players', Date '2020-2-15', Date '2020-3-15');
insert into project (project_id, name, stage, description, start_date, end_date) values (1002, 'Stadium Construction', 'COMPLETED', 'Build new Stadium', Date '2020-1-24', Date '2020-7-25');
insert into project (project_id, name, stage, description, start_date, end_date) values (1003, 'Win SuperBowl', 'INPROGRESS', 'Win against Brady', Date '2020-2-2', Date '2020-2-10');

-- INSERT PROJECT_EMPLOYEE_RELATION (Removed duplicates from video)
insert into project_employee (employee_id, project_id) values (1,1000);
insert into project_employee (employee_id, project_id) values (1,1001);
insert into project_employee (employee_id, project_id) values (1,1002);
insert into project_employee (employee_id, project_id) values (3,1000);
insert into project_employee (employee_id, project_id) values (6,1002);
insert into project_employee (employee_id, project_id) values (6,1003);