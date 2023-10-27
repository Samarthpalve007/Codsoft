import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int registeredStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailableSlots() {
        return capacity - registeredStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean registerStudent() {
        if (registeredStudents < capacity) {
            registeredStudents++;
            return true;
        }
        return false;
    }

    public void removeStudent() {
        if (registeredStudents > 0) {
            registeredStudents--;
        }
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
            System.out.println("Course " + course.getCourseCode() + " registered successfully for student " + name + ".");
        } else {
            System.out.println("Course " + course.getCourseCode() + " is full. Cannot register for student " + name + ".");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.removeStudent();
            registeredCourses.remove(course);
            System.out.println("Course " + course.getCourseCode() + " dropped successfully for student " + name + ".");
        } else {
            System.out.println("Student " + name + " is not registered for course " + course.getCourseCode() + ".");
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Course mathCourse = new Course("MATH101", "Introduction to Mathematics", "Basic math concepts", 30, "Mon/Wed 10:00 AM");
        Course historyCourse = new Course("HIST201", "World History", "History of the world civilizations", 25, "Tue/Thu 2:00 PM");

        Student student1 = new Student(1, "Samarth");
        Student student2 = new Student(2, "Rajan");
        Student student3 = new Student(3, "Saket");
        Student student4 = new Student(4, "Virat");
        Student student5 = new Student(5, "Aakansha");

        student1.registerCourse(mathCourse);
        student1.registerCourse(historyCourse);
        student2.registerCourse(mathCourse);
        student3.registerCourse(historyCourse);
        student4.registerCourse(mathCourse);
        student5.registerCourse(historyCourse);

        System.out.println("Course Listing:");
        System.out.println(mathCourse.getCourseCode() + " - " + mathCourse.getTitle() +
                " | Available Slots: " + mathCourse.getAvailableSlots() + " | Schedule: " + mathCourse.getSchedule());
        System.out.println(historyCourse.getCourseCode() + " - " + historyCourse.getTitle() +
                " | Available Slots: " + historyCourse.getAvailableSlots() + " | Schedule: " + historyCourse.getSchedule());

        student1.dropCourse(mathCourse);
        student3.dropCourse(historyCourse);

        System.out.println("\nUpdated Course Listing:");
        System.out.println(mathCourse.getCourseCode() + " - " + mathCourse.getTitle() +
                " | Available Slots: " + mathCourse.getAvailableSlots() + " | Schedule: " + mathCourse.getSchedule());
        System.out.println(historyCourse.getCourseCode() + " - " + historyCourse.getTitle() +
                " | Available Slots: " + historyCourse.getAvailableSlots() + " | Schedule: " + historyCourse.getSchedule());
    }
}
