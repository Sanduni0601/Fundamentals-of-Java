class Student {
    private String name;
    private double marks;
    
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }
 
    public double getMarks() {
        return marks;
    }
    
    public String toString() {
        return "Student [name=" + name +  ", marks=" + marks + "]";
    }
}

public class sixth {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        
        // Creating 5 student objects
        students[0] = new Student("Alice", 85.5);
        students[1] = new Student("Bob", 77.0);
        students[2] = new Student("Charlie", 92.5);
        students[3] = new Student("David", 68.5);
        students[4] = new Student("Eva", 88.0);
  
        double totalMarks = 0;
        for (Student student : students) {
            totalMarks += student.getMarks();
        }
        
        double averageMarks = totalMarks / students.length;

        System.out.println("\nAverage marks: " + averageMarks);
    }
}