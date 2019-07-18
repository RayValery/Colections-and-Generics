package Map.TreeMap;

import Map.TreeMap.AvarageStudentGrade;
import Map.TreeMap.SubjectGrade;

import java.util.*;

public class TreeMapRunner {

    public static void main(String[] args) {
        NavigableMap<AvarageStudentGrade,Set<SubjectGrade>> grades = createGrades();
        printMap(grades, true);
    }

    private static void printMap(NavigableMap<AvarageStudentGrade,Set<SubjectGrade>> map, boolean printValues){
        Set<AvarageStudentGrade> keys = map.keySet();
        for (AvarageStudentGrade key : map.keySet()){
            System.out.println(key.toString());
            if(printValues){
            System.out.println(map.get(key).toString());}
        }
    }

    private static float avarageGrade(Set<SubjectGrade> grades) {
        int sum = 0;
        for (SubjectGrade grade : grades) {
            sum += grade.getGrade();
        }
        return sum / grades.size();
    }

    private static NavigableMap<AvarageStudentGrade,Set<SubjectGrade>> createGrades() {
        Set<SubjectGrade> alexGrade = new HashSet<>();
        alexGrade.add(new SubjectGrade("History", 80));
        alexGrade.add(new SubjectGrade("Math", 85));
        alexGrade.add(new SubjectGrade("Phisics", 70));
        alexGrade.add(new SubjectGrade("English", 93));
        alexGrade.add(new SubjectGrade("Programming", 87));

        Set<SubjectGrade> jorgeGrade = new HashSet<>();
        jorgeGrade.add(new SubjectGrade("History", 60));
        jorgeGrade.add(new SubjectGrade("Math", 55));
        jorgeGrade.add(new SubjectGrade("Phisics", 40));
        jorgeGrade.add(new SubjectGrade("English", 63));
        jorgeGrade.add(new SubjectGrade("Programming", 77));

        Set<SubjectGrade> mikleGrades = new HashSet<>();
        mikleGrades.add(new SubjectGrade("History", 40));
        mikleGrades.add(new SubjectGrade("Math", 55));
        mikleGrades.add(new SubjectGrade("Phisics", 60));
        mikleGrades.add(new SubjectGrade("English", 83));
        mikleGrades.add(new SubjectGrade("Programming", 87));

        Set<SubjectGrade> aliceGrade = new HashSet<>();
        aliceGrade.add(new SubjectGrade("History", 90));
        aliceGrade.add(new SubjectGrade("Math", 95));
        aliceGrade.add(new SubjectGrade("Phisics", 92));
        aliceGrade.add(new SubjectGrade("English", 93));
        aliceGrade.add(new SubjectGrade("Programming", 97));

        Set<SubjectGrade> jorjerGrade = new HashSet<>();
        jorjerGrade.add(new SubjectGrade("History", 60));
        jorjerGrade.add(new SubjectGrade("Math", 55));
        jorjerGrade.add(new SubjectGrade("Phisics", 40));
        jorjerGrade.add(new SubjectGrade("English", 63));
        jorjerGrade.add(new SubjectGrade("Programming", 77));

        NavigableMap<AvarageStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
        map.put(new AvarageStudentGrade("Alex", avarageGrade(alexGrade)), alexGrade);
        map.put(new AvarageStudentGrade("Jorge", avarageGrade(jorgeGrade)), jorgeGrade);
        map.put(new AvarageStudentGrade("Mikle", avarageGrade(mikleGrades)), mikleGrades);
        map.put(new AvarageStudentGrade("Alice", avarageGrade(aliceGrade)), aliceGrade);
        map.put(new AvarageStudentGrade("Jorjer", avarageGrade(jorjerGrade)), jorjerGrade);

        return map;
    }
}
