package es.ulpgc.eite.studentgrade.grade;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.studentgrade.app.AppMediator;
import es.ulpgc.eite.studentgrade.app.GradeToStudentState;
import es.ulpgc.eite.studentgrade.app.StudentToGradeState;

/**
 * Created by Luis on marzo, 2022
 */
public class GradePresenter implements GradeContract.Presenter {

  public static String TAG = "StudentGrade.GradePresenter";

  private WeakReference<GradeContract.View> view;
  private GradeState state;
  private GradeContract.Model model;
  private AppMediator mediator;

  public GradePresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getGradeState();
  }

  @Override
  public void onStart() {
     Log.e(TAG, "onStart()");

    // TODO: include code here if is necessary

    // use passed state if is necessary
    StudentToGradeState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // TODO: include code here if is necessary
      state.btnStudentClicked = savedState.btnClicked;
      if(state.btnStudentClicked==1){
        state.nota1 = String.valueOf(9);
        state.nota2 = String.valueOf(10);
      } else if (state.btnStudentClicked==2){
        state.nota1 = String.valueOf(7);
        state.nota2 = String.valueOf(8);
      } else if (state.btnStudentClicked==3){
        state.nota1 = String.valueOf(5);
        state.nota2 = String.valueOf(6);
      }

    }

    // TODO: include code here if is necessary
      view.get().onDataUpdated(state);
  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    // TODO: include code here if is necessary
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    // TODO: include code here if is necessary

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");

    // TODO: include code here if is necessary

    GradeToStudentState newState = new GradeToStudentState(state.grade);
    passStateToPreviousScreen(newState);
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");

    // TODO: include code here if is necessary
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");

    // TODO: include code here if is necessary
  }


  @Override
  public void onHigherGradeBtnClicked() {

    // TODO: include code here if is necessary
      state.btnGradeClicked=2 ;
      state.HigherGradeBtnClicke=true;
      model.setGrade(Integer.parseInt(state.nota2));
    state.grade = model.getGrade();
    view.get().navigateToPreviousScreen();
  }

  @Override
  public void onLowerGradeBtnClicked() {

    // TODO: include code here if is necessary
        state.btnGradeClicked=1;
        state.LowerGradeBtnClicked=true;
        model.setGrade(Integer.parseInt(state.nota1));
        state.grade = model.getGrade();
    view.get().navigateToPreviousScreen();
  }

  private void passStateToPreviousScreen(GradeToStudentState state) {
    mediator.setPreviousGradeScreenState(state);
  }

  private StudentToGradeState getStateFromPreviousScreen() {
    return mediator.getPreviousGradeScreenState();
  }

  @Override
  public void injectView(WeakReference<GradeContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(GradeContract.Model model) {
    this.model = model;
  }

}
