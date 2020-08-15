-- Reports all the student of a specific class when you know a specific class ID
SELECT class.classID, class.classTitle, class.classDescription, student.studentID, student.studentFirstName, student.studentLastName, teacher.teacherID, teacher.teacherFirstName, teacher.teacherLastName, mapclassyear.classYear FROM mapclassyear
INNER JOIN class ON mapclassyear.fkClassID = class.classID
INNER JOIN mapclassstudent ON mapclassstudent.fkClassMapID = mapclassyear.mapID 
INNER JOIN mapclassteacher ON mapclassteacher.fkClassMapID = mapclassyear.mapID
INNER JOIN student ON mapclassstudent.fkStudentID = student.studentID
INNER JOIN teacher ON mapclassteacher.fkTeacherID = teacher.teacherID
WHERE class.classID = 1
ORDER BY mapclassyear.classYear;

-- Reports all the student of a specific class when you know a specific class name (in a specific year)
SELECT class.classID, class.classTitle, class.classDescription, student.studentID, student.studentFirstName, student.studentLastName, teacher.teacherID, teacher.teacherFirstName, teacher.teacherLastName, mapclassyear.classYear FROM mapclassyear
INNER JOIN class ON mapclassyear.fkClassID = class.classID
INNER JOIN mapclassstudent ON mapclassstudent.fkClassMapID = mapclassyear.mapID 
INNER JOIN mapclassteacher ON mapclassteacher.fkClassMapID = mapclassyear.mapID
INNER JOIN student ON mapclassstudent.fkStudentID = student.studentID
INNER JOIN teacher ON mapclassteacher.fkTeacherID = teacher.teacherID
WHERE class.classTitle = "php" AND mapclassyear.classYear = 2016
ORDER BY mapclassyear.classYear;

