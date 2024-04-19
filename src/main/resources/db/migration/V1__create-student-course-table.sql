CREATE TABLE IF NOT EXISTS student (
  id UUID UNIQUE NOT NULL,
  name VARCHAR(100) NOT NULL,
  registration BIGINT UNIQUE NOT NULL,
  PRIMARY KEY(id, registration)
);

CREATE TABLE IF NOT EXISTS course (
  id UUID UNIQUE NOT NULL,
  name VARCHAR(100) NOT NULL,
  description TEXT NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS student_course (
  id UUID UNIQUE NOT NULL,
  student_id UUID,
  course_id UUID,
  PRIMARY KEY(id),
  FOREIGN KEY(student_id) REFERENCES student(id),
  FOREIGN KEY(course_id) REFERENCES course(id)
);