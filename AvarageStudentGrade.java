package Map.TreeMap;

public class AvarageStudentGrade implements Comparable {
    private final String name;
    private final float avarGrade;

    public AvarageStudentGrade(String name, float avarGrade) {
        this.name = name;
        this.avarGrade = avarGrade;
    }

    public String getName() {
        return name;
    }

    public float getAvarGrade() {
        return avarGrade;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof AvarageStudentGrade)) {
            throw new UnsupportedOperationException();
        } else if (this.getAvarGrade() < ((AvarageStudentGrade) o).getAvarGrade()) {
            return 1;
        } else if (this.getAvarGrade() > ((AvarageStudentGrade) o).getAvarGrade()) {
            return -1;
        } else return (this.getName().compareTo(((AvarageStudentGrade) o).getName()));

    }

    @Override
    public String toString() {
        return "\nName: " + name + "\n" +
                "Avarage grade: " + avarGrade;
    }
}
