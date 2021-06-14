create table employees
(
	id int not null,
	name varchar,
	login varchar not null,
	password varchar not null,
	position int,
	salary int
);

create unique index employees_id_uindex
	on employees (id);

alter table employees
	add constraint employees_pk
		primary key (id);

create table projects
(
	id int not null,
	name varchar
);

create unique index projects_id_uindex
	on projects (id);

alter table projects
	add constraint projects_pk
		primary key (id);

create table tasks
(
	id int not null,
	name varchar,
	project_id int not null
		constraint tasks_projects_id_fk
			references projects
				on update cascade on delete cascade,
	qualification int,
	workers_num int
);

create unique index tasks_id_uindex
	on tasks (id);

create table developing
(
	employee_id int not null
		constraint developing_employees_id_fk
			references employees
				on update cascade on delete cascade,
	task_id int not null
		constraint developing_tasks_id_fk
			references tasks (id)
				on update cascade on delete cascade,
	hrs int,
	active boolean default false
);
