package es.ulpgc.eite.studentgrade.grade;

/**
 * Created by Luis on marzo, 2022
 */
public class GradeModel implements GradeContract.Model {

  public static String TAG = "StudentGrade.GradeModel";

  private String data;
  private int btnClicked;
  private int grade;

  public GradeModel(String data) {
    this.data = data;
  }

  @Override
  public String getStoredData() {
    // Log.e(TAG, "getStoredDgradeata()");
    return data;
  }

  @Override
  public void onRestartScreen(String data) {
    // Log.e(TAG, "onRestartScreen()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onDataFromPreviousScreen(String data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");

    // TODO: include code here if is necessary
  }
  @Override
  public int getGrade(){return grade;}

  public void setGrade(int grade1){
      grade = grade1;
  }
}