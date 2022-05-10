package seminar.seminar2.g1058;

import java.util.Arrays;

public class Student extends Persoana {
    private int grupa, anul;
    private Disciplina[] discipline;
    private int[] note;

    public Student() {
    }

    public Student(long cnp) {
        super(cnp);
    }

    public Student(long cnp, String nume, Adresa adresa, int grupa, int anul, Disciplina[] discipline, int[] note)
            throws Exception {
        super(cnp, nume, adresa);
        if (discipline.length!=note.length){
            throw new Exception("Dimensiuni incorecte pentru discipline si note!");
        }
        this.grupa = grupa;
        this.anul = anul;
        this.discipline = discipline;
        this.note = note;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    public int getAnul() {
        return anul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }

    public Disciplina[] getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Disciplina[] discipline) throws Exception{
        if (discipline.length!=note.length){
            throw new Exception("Dimensiuni incorecte pentru discipline si note!");
        }
        this.discipline = discipline;
    }

    public int[] getNote() {
        return note;
    }

    public void setNote(int[] note) throws Exception {
        if (discipline.length!=note.length){
            throw new Exception("Dimensiuni incorecte pentru discipline si note!");
        }
        this.note = note;
    }

    @Override
    public String toString() {
        return super.toString() + "{" + grupa + "," + anul + "," +
                Arrays.toString(discipline) + "," + Arrays.toString(note) + "}";
    }

    @Override
    public boolean evaluare() {
        for (int i = 0; i < note.length; i++) {
            if (note[i]<5){
                return false;
            }
        }
        return true;
    }

    @Override
    public double medie() {
        double v = 0;
        for (int nota:note){
            v+=nota;
        }
        return v/note.length;
    }

    @Override
    public int compareTo(Persoana o) {
        Student student = (Student) o;
        if(this.medie()==student.medie()){
            return 0;
        } else {
            if (this.medie() < student.medie()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
