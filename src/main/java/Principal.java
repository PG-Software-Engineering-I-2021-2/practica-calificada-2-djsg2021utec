import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Principal {
    final private Map<Integer, List<Pair<Teacher, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( new ProfesorTC("Josefina"), true),
                            new Pair<>( new ProfesorTC("Edonisio"), true),
                            new Pair<>( new ProfesorTC("Edufasio"), false)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( new ProfesorTC("Eduarda"), false),
                            new Pair<>( new ProfesorTC("Abelardo"), false),
                            new Pair<>( new ProfesorTC("Francisca"), false)
                    )
            )
    );
    private final int yearToCalculate;

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }
    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (!examsStudents.isEmpty()) {

            boolean hasToIncreaseOneExtraPoint = false;
            int gradesWeightSum;
            float gradesSum;

            gradesSum = getGradesSum(examsStudents);
            gradesWeightSum = getGradesWeightSum(examsStudents);
            return  gradeExamNotEmpty(gradesSum, gradesWeightSum, hasReachedMinimumClasses, hasToIncreaseOneExtraPoint);
        } else {
            return 0f;
        }
    }

    public float gradeExamNotEmpty(float gradesSum, int gradesWeightSum, boolean hasReachedMinimumClasses, boolean hasToIncreaseOneExtraPoint){
        if (gradesWeightSum == 100) {
            if (hasReachedMinimumClasses) {
                if (isHasToIncreaseOneExtraPoint(hasToIncreaseOneExtraPoint)) {
                    return Float.min(10f, gradesSum + 1);
                } else {
                    return gradesSum;
                }
            } else {
                return 0f;
            }
        }
        if (gradesWeightSum > 100) {
            return -1f;
        }
        return -2f;
    }

    private int getGradesWeightSum(List<Pair<Integer, Float>> examsStudents) {
        int gradesWeightSum = 0;
        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesWeightSum += examGrade.first();
        }
        return gradesWeightSum;
    }

    private float getGradesSum(List<Pair<Integer, Float>> examsStudents) {
        float gradesSum = 0f;
        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesSum += (examGrade.first() * examGrade.second() / 100);
        }
        return gradesSum;
    }

    private boolean isHasToIncreaseOneExtraPoint(boolean hasToIncreaseOneExtraPoint) {
        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (!(yearToCalculate != yearlyTeachers.getKey())) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (teacher.second() != true) {
                        continue;
                    }
                    hasToIncreaseOneExtraPoint = true;
                }
            } else {
                continue;
            }
        }
        return hasToIncreaseOneExtraPoint;
    }

    public static void main(String[] args) {
        System.out.println("Hola");
    }
}
