// In computer science, a priority queue is an abstract data type which is like a regular queue, but where additionally each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority

// Sample Input 0
// 12
// ENTER John 3.75 50
// ENTER Mark 3.8 24
// ENTER Shafaet 3.7 35
// SERVED
// SERVED
// ENTER Samiha 3.85 36
// SERVED
// ENTER Ashley 3.9 42
// ENTER Maria 3.6 46
// ENTER Anik 3.95 49
// ENTER Dan 3.95 50
// SERVED

// Sample Output 0
// Dan
// Ashley
// Shafaet
// Maria

// Explanation 0
// In this case, the number of events is 12. Let the name of the queue be Q.

// John is added to Q. So, it contains (John, 3.75, 50).
// Mark is added to Q. So, it contains (John, 3.75, 50) and (Mark, 3.8, 24).
// Shafaet is added to Q. So, it contains (John, 3.75, 50), (Mark, 3.8, 24), and (Shafaet, 3.7, 35).
// Mark is served as he has the highest CGPA. So, Q contains (John, 3.75, 50) and (Shafaet, 3.7, 35).
// John is served next as he has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
// Samiha is added to Q. So, it contains (Shafaet, 3.7, 35) and (Samiha, 3.85, 36).
// Samiha is served as she has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
// Now, four more students are added to Q. So, it contains (Shafaet, 3.7, 35), (Ashley, 3.9, 42), (Maria, 3.6, 46), (Anik, 3.95, 49), and (Dan, 3.95, 50).
// Anik is served because though both Anil and Dan have the highest CGPA but Anik comes first when sorted in alphabetic order. So, Q contains (Dan, 3.95, 50), (Ashley, 3.9, 42), (Shafaet, 3.7, 35), and (Maria, 3.6, 46).
// As all events are completed, the name of each of the remaining students is printed on a new line.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */

class Student{
    private int id;
    private String name;
    private double cgpa;
    
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class Priorities{
    Queue<Student> q = new PriorityQueue<Student>(
        new Comparator<Student>(){
            @Override
            public int compare(Student a, Student b){
                if(a.getCgpa()==b.getCgpa() && a.getName().equals(b.getName())){
                    return a.getId() - b.getId();
                }
                else if(a.getCgpa()==b.getCgpa()){
                    return a.getName().compareTo(b.getName());
                }
                else{
                    return (int)(10000*(b.getCgpa()-a.getCgpa()));
                }
            }
        }
    );
    
    public List<Student> getStudents(List<String> events){
        for(int i=0; i<events.size();i++){
            if(events.get(i).split(" ")[0].equals("ENTER")){
                String StName = events.get(i).split(" ")[1];
                double StCgpa = Double.parseDouble(events.get(i).split(" ")[2]);
                int StId = Integer.parseInt(events.get(i).split(" ")[3]);
                q.add(new Student(StId,StName,StCgpa));
            }
            else if(events.get(i).equals("SERVED")){
                q.poll();
            }
        }
        List<Student> output = new ArrayList<Student>();
        int queuelength = q.size();
        for (int i = 0 ; i< queuelength; i++) {
           output.add(q.poll());
        }
        return output;
    }
    
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}