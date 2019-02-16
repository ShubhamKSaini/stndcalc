package loopintechies.com.calculator;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    float first_num, sec_num, res = 0;
    boolean multi = false, divn = false, add = false, sub = false, equalis = false, modis = false;
    TextView Res;
    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, mul, div, mod, equal, point, clear, buttoncut;
    EditText input_user;
    String opr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideKeyboard();
        setIs();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        input_user.setSelection(0);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        point.setOnClickListener(this);
        clear.setOnClickListener(this);
        mod.setOnClickListener(this);
        equal.setOnClickListener(this);
        zero.setOnClickListener(this);
        buttoncut.setOnClickListener(this);
    }


    private void setIs() {
        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        zero = findViewById(R.id.button0);
        plus = findViewById(R.id.buttonplus);
        minus = findViewById(R.id.buttonminus);
        mul = findViewById(R.id.buttonmulti);
        div = findViewById(R.id.buttondiv);
        mod = findViewById(R.id.buttonmod);
        equal = findViewById(R.id.buttonequal);
        point = findViewById(R.id.buttonpoint);
        clear = findViewById(R.id.buttonclear);
        input_user = findViewById(R.id.edt1);
        Res = findViewById(R.id.result_view);
        buttoncut = findViewById(R.id.buttoncut);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button0:
                if (!equalis)
                    input_user.append("0");
                else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append("0");
                }
                break;
            case R.id.button1:
                if (!equalis)
                    input_user.append("1");
                else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append("1");
                }
                break;
            case R.id.button2:
                if (!equalis)
                    input_user.append("2");
                else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append("2");
                }
                break;
            case R.id.button3:
                if (!equalis)
                    input_user.append("3");
                else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append("3");
                }
                break;
            case R.id.button4:
                if (!equalis)
                    input_user.append("4");
                else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append("4");
                }
                break;
            case R.id.button5:
                if (!equalis)
                    input_user.append("5");
                else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append("5");
                }
                break;
            case R.id.button6:
                if (!equalis)
                    input_user.append("6");
                else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append("6");
                }
                break;
            case R.id.button7:
                if (!equalis)
                    input_user.append("7");
                else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append("7");
                }
                break;
            case R.id.button8:
                if (!equalis)
                    input_user.append("8");
                else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append("8");
                }
                break;
            case R.id.button9:
                if (!equalis)
                    input_user.append("9");
                else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append("9");
                }
                break;
            case R.id.buttonpoint:
                if (!equalis) {
                    String it = String.valueOf((input_user.getText().toString().trim()));
                    if (!it.contains("."))
                        input_user.append(".");
                } else {
                    equalis = false;
                    input_user.setText("");
                    Res.setText("");
                    input_user.append(".");
                }
                break;
            case R.id.buttonclear:
                input_user.setText("");
                Res.setText("");
                equalis = false;
                res = 0;
                add = false;
                sub = false;
                multi = false;
                divn = false;
                modis = false;
                break;

            case R.id.buttoncut: {
                String text = input_user.getText().toString().trim();
                if (text.length() >= 1) {
                    String textString = text.substring(0, text.length() - 1);
                    input_user.setText(textString);
                }
            }
            break;
            case R.id.buttonplus:
                if (!input_user.getText().toString().trim().isEmpty()) {
                    if (!equalis) {
                        first_num = Float.parseFloat(input_user.getText().toString().trim());
                        if (res <= 0)
                            res = first_num;
                        else
                            res += Float.parseFloat(input_user.getText().toString().trim());
                        add = true;
                        sub = false;
                        multi = false;
                        divn = false;
                        modis = false;
                        Res.append(first_num + " + ");
                        input_user.setText("");
                    } else {
                        equalis = false;
                        Res.setText("");
                        res = Float.parseFloat(input_user.getText().toString().trim());
                        add = true;
                        sub = false;
                        multi = false;
                        divn = false;
                        modis = false;
                        Res.append(res + " + ");
                        input_user.setText("");
                    }
                }
                break;
            case R.id.buttonminus:
                if (!input_user.getText().toString().trim().isEmpty()) {
                    if (!equalis) {
                        first_num = Float.parseFloat(input_user.getText().toString().trim());
                        if (res <= 0)
                            res = first_num;
                        else
                            res -= Float.parseFloat(input_user.getText().toString().trim());
                        add = false;
                        sub = true;
                        multi = false;
                        divn = false;
                        modis = false;
                        Res.append(first_num + " - ");
                        input_user.setText("");
                    } else {
                        equalis = false;
                        Res.setText("");
                        res = Float.parseFloat(input_user.getText().toString().trim());
                        Log.d("test", "onClick: " + res);
                        add = false;
                        sub = true;
                        multi = false;
                        divn = false;
                        modis = false;
                        first_num = Float.parseFloat(input_user.getText().toString().trim());
                        Res.append(res + " - ");
                        input_user.setText("");
                    }
                }
                break;
            case R.id.buttondiv:
                if (!input_user.getText().toString().trim().isEmpty()) {
                    if (!equalis) {
                        first_num = Float.parseFloat(input_user.getText().toString().trim());
                        if (res <= 0)
                            res = first_num;
                        else
                            res /= Float.parseFloat(input_user.getText().toString().trim());
                        add = false;
                        sub = false;
                        multi = false;
                        divn = true;
                        modis = false;
                        Res.append(first_num + " / ");
                        input_user.setText("");
                    } else {
                        equalis = false;
                        Res.setText("");
                        res = Float.parseFloat(input_user.getText().toString().trim());
                        add = false;
                        sub = false;
                        multi = false;
                        divn = true;
                        modis = false;
                        Res.append(res + " / ");
                        input_user.setText("");
                    }
                }
                break;
            case R.id.buttonmulti:
                if (!input_user.getText().toString().trim().isEmpty()) {
                    if (!equalis) {
                        first_num = Float.parseFloat(input_user.getText().toString().trim());
                        if (res <= 0)
                            res = first_num;
                        else
                            res *= Float.parseFloat(input_user.getText().toString().trim());
                        add = false;
                        sub = false;
                        multi = true;
                        divn = false;
                        modis = false;
                        Res.append(first_num + " * ");
                        input_user.setText("");
                    } else {
                        equalis = false;
                        Res.setText("");
                        res = Float.parseFloat(input_user.getText().toString().trim());
                        add = false;
                        sub = false;
                        multi = true;
                        divn = false;
                        modis = false;
                        Res.append(res + " * ");
                        input_user.setText("");
                    }
                }
                break;
            case R.id.buttonmod:
                if (!input_user.getText().toString().trim().isEmpty()) {
                    if (!equalis) {
                        first_num = Float.parseFloat(input_user.getText().toString().trim());
                        if (res <= 0.0)
                            res = first_num;
                        else
                            res = ((res / 100) * Float.parseFloat(input_user.getText().toString().trim()));
                        add = false;
                        sub = false;
                        multi = false;
                        divn = false;
                        modis = true;
                        Res.append(first_num + " % ");
                        input_user.setText("");
                    } else {
                        equalis = false;
                        Res.setText("");
                        res = Float.parseFloat(input_user.getText().toString().trim());
                        add = false;
                        sub = false;
                        multi = false;
                        divn = false;
                        modis = true;
                        Res.append(res + " % ");
                        input_user.setText("");
                    }
                }
                break;
            case R.id.buttonequal:
                equalis = true;
                if (!input_user.getText().toString().trim().isEmpty())
                    sec_num = Float.parseFloat(input_user.getText().toString().trim());
                else
                    sec_num = 0;
                if (getOpr() != null) {
                    Log.d("check_opr", "onClick: " + getOpr());
                    opr = getOpr();
                } else
                    break;

                switch (opr) {
                    case "+":
                        if (TextUtils.isEmpty(String.valueOf(sec_num)) || sec_num <= 0.0) {
                            input_user.setText(String.valueOf((res)));
                            Res.setText(String.valueOf(res + " + "));
                        } else {
                            input_user.setText(String.valueOf(res + sec_num));
                            Res.setText(String.valueOf(res + " + " + sec_num));
                        }
                        break;
                    case "-":
                        if (TextUtils.isEmpty(String.valueOf(sec_num)) || sec_num <= 0.0) {
                            input_user.setText(String.valueOf((res)));
                            Res.setText(String.valueOf(res + " - "));
                        } else {
                            input_user.setText(String.valueOf(res - sec_num));
                            Res.setText(String.valueOf(res + " - " + sec_num));
                        }
                        break;
                    case "*":
                        if (TextUtils.isEmpty(String.valueOf(sec_num)) || sec_num <= 0.0) {
                            input_user.setText(String.valueOf((res)));
                            Res.setText(String.valueOf(res + " * "));
                        } else {
                            input_user.setText(String.valueOf(res * sec_num));
                            Res.setText(String.valueOf(res + " * " + sec_num));
                        }
                        break;
                    case "/":
                        if (TextUtils.isEmpty(String.valueOf(sec_num)) || sec_num <= 0.0) {
                            input_user.setText(String.valueOf((res)));
                            Res.setText(String.valueOf(res + " / "));
                        } else {
                            input_user.setText(String.valueOf(res / sec_num));
                            Res.setText(String.valueOf(res + " / " + sec_num));
                        }
                        break;
                    case "%":

                        if (TextUtils.isEmpty(String.valueOf(sec_num)) || sec_num <= 0.0) {
                            input_user.setText(String.valueOf((res / 100)));
                            Res.setText(String.valueOf(res + " % "));
                        } else {
                            input_user.setText(String.valueOf((res / 100) * sec_num));
                            Res.setText(String.valueOf(res + " % " + sec_num));
                        }
                        break;

                }
                add = false;
                sub = false;
                multi = false;
                divn = false;
                modis = false;
                res = 0;
                break;

        }

    }


    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    private String getOpr() {
        String opr = null;
        if (add)
            opr = "+";
        else if (sub)
            opr = "-";
        else if (multi)
            opr = "*";
        else if (divn)
            opr = "/";
        else if (modis)
            opr = "%";
        return opr;
    }
}
