package es.ulpgc.eite.studentgrade.student;

/**
 * Created by Luis on marzo, 2022
 */
public class StudentModel implements StudentContract.Model {

  public static String TAG = "StudentGrade.StudentModel";

  private String data;
  private String notasAltas;
  private String notasMedias;
  private String notasBajas;

  private int studentGrade;
  private boolean btnClicked;

  public StudentModel(String data) {
    this.data = data;
  }

  @Override
  public String getStoredData() {
    // Log.e(TAG, "getStoredData()");

    return data;
  }

  @Override
  public void onRestartScreen(String data) {
    // Log.e(TAG, "onRestartScreen()");

    // TODO: include code here if is necessary
  }

  @Override
  public void onDataFromNextScreen(String data) {
    // Log.e(TAG, "onDataFromNextScreen()");

    // TODO: include code here if is necessary
  }

  @Override
  public String getnotasAltas() {
    return notasAltas;
  }

  @Override
  public String getnotasMedias() {
    return notasMedias;
  }

  @Override
  public String getnotasBajas() {
    return notasBajas;
  }

  @Override
  public int getstudentGrade() {
    return studentGrade;
  }

}