package com.example.unitconverter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Arrays;

public class length_cal extends AppCompatActivity {
    CardView cv_fromUnit, cv_toUnit, cv_convert;
    RelativeLayout mCLayout;
    String fromUnit = "inch";
    String toUnit = "Inch";
    TextView tv_fromUnit, tv_toUnit;
    EditText et_fromUnit, et_toUnit;
    final String[] values = new String[]{
            "Inch",
            "Foot",
            "Yard",
            "Mile",
            "CM", "KM"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_cal);

        cv_fromUnit = findViewById(R.id.fromUnit);
        cv_toUnit = findViewById(R.id.toUnit);
        cv_convert = findViewById(R.id.cv_convert);

        mCLayout = findViewById(R.id.temp_relativeLayout);

        tv_fromUnit = findViewById(R.id.tv_fromUnit);
        tv_toUnit = findViewById(R.id.tv_toUnit);

        tv_fromUnit.setText(values[0]);
        tv_toUnit.setText(values[0]);

        et_fromUnit = findViewById(R.id.et_fromUnit);
        et_toUnit = findViewById(R.id.et_toUnit);

        cv_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempInput = et_fromUnit.getText().toString();
                if (tempInput.equals("") || tempInput == null) {
                    et_fromUnit.setError("Please enter some value");
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(inchToFoot(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(inchToYard(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(inchToMile(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(inchToMile(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(inchToCM(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[6])) {
                            et_toUnit.setText(inchToKM(Double.parseDouble(tempInput)));
                        }

                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(footToInch(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(footToYard(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(footToMile(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(footToCM(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(footToKM(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(YardToInch(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(YardToFoot(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(YardToMile(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(YardToCM(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(YardToKM(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(mileToInch(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(mileToFoot(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(mileToYard(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(mileToCM(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(mileToKM(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(cmToInch(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(cmToFoot(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(cmToYard(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(cmTomile(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(cmToKM(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[5])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(kmToInch(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(kmToFoot(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(kmToYard(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(kmToMile(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(kmToCM(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(tempInput);
                        }
                    }
                }
            }
        });

        cv_toUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(length_cal.this);
                builder.setTitle("choose Unit");

                final String[] flowers = new String[]{
                        "Inch",
                        "Foot",
                        "Yard",
                        "Mile",
                        "CM", "KM"
                };

                builder.setSingleChoiceItems(
                        flowers, // Items list
                        -1, // Index of checked item (-1 = no selection)
                        new DialogInterface.OnClickListener() // Item click listener
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Get the alert dialog selected item's text
                                String selectedItem = Arrays.asList(flowers).get(i);
                                toUnit = selectedItem;
                                tv_toUnit.setText(toUnit);

                            }
                        });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Just dismiss the alert dialog after selection
                        // Or do something now
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();

                // Finally, display the alert dialog
                dialog.show();

            }
        });

        cv_fromUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(length_cal.this);
                builder.setTitle("choose Unit");

                final String[] flowers = new String[]{
                        "Inch",
                        "Foot",
                        "Yard",
                        "Mile",
                        "CM", "KM"
                };

                builder.setSingleChoiceItems(
                        flowers, // Items list
                        -1, // Index of checked item (-1 = no selection)
                        new DialogInterface.OnClickListener() // Item click listener
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Get the alert dialog selected item's text
                                String selectedItem = Arrays.asList(flowers).get(i);
                                fromUnit = selectedItem;
                                tv_fromUnit.setText(fromUnit);

                            }
                        });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Just dismiss the alert dialog after selection
                        // Or do something now
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();

                // Finally, display the alert dialog
                dialog.show();

            }
        });

    }

    //Inch
    private String inchToFoot(double inch) {
        double foot = inch * 0.083;
        return String.valueOf(foot);
    }

    private String inchToYard(double inch) {
        double yard = inch / 36;
        return String.valueOf(yard);
    }

    private String inchToMile(double inch) {
        double mile = inch / 63360;
        return String.valueOf(mile);
    }

    private String inchToCM(double inch) {
        double cm = inch * 2.54;
        return String.valueOf(cm);
    }

    private String inchToKM(double inch) {
        double km = inch / 393.70;
        return String.valueOf(km);
    }


    //Foot
    private String footToInch(double foot) {
        double inch = foot * 12;
        return String.valueOf(inch);
    }

    private String footToYard(double foot) {
        double yard = foot / 3;
        return String.valueOf(yard);
    }

    private String footToMile(double foot) {
        double mile = foot * 0.0001894;
        return String.valueOf(mile);
    }

    private String footToCM(double foot) {
        double cm = foot * 30.48;
        return String.valueOf(cm);
    }

    private String footToKM(double foot) {
        double km = foot * 3280.839895;
        return String.valueOf(km);
    }


    //Yard
    private String YardToInch(double yard) {
        double inch = yard * 36;
        return String.valueOf(inch);
    }

    private String YardToFoot(double yard) {
        double foot = yard * 3;
        return String.valueOf(foot);
    }

    private String YardToMile(double yard) {
        double mile = yard / 1760;
        return String.valueOf(mile);
    }

    private String YardToCM(double yard) {
        double cm = yard * 91.44;
        return String.valueOf(cm);
    }

    private String YardToKM(double yard) {
        double km = yard * 0.0009144;
        return String.valueOf(km);
    }


    //Mile
    private String mileToInch(double mile) {
        double inch = mile * 63360;
        return String.valueOf(inch);
    }

    private String mileToFoot(double mile) {
        double foot = mile * 5280;
        return String.valueOf(foot);
    }

    private String mileToYard(double mile) {
        double yard = mile * 1760;
        return String.valueOf(yard);
    }

    private String mileToCM(double mile) {
        double cm = mile *160934.4;
        return String.valueOf(cm);
    }

    private String mileToKM(double mile) {
        double km = mile / 1.609344;
        return String.valueOf(km);
    }


    //CM
    private String cmToInch(double cm) {
        double inch = cm * 0.393701;
        return String.valueOf(inch);
    }

    private String cmToFoot(double cm) {
        double foot = cm * 0.0328;
        return String.valueOf(foot);
    }

    private String cmToYard(double cm) {
        double yard = cm * 0.010936133;
        return String.valueOf(yard);
    }

    private String cmTomile(double cm) {
        double mile = cm / 160924.4;
        return String.valueOf(mile);
    }

    private String cmToKM(double cm) {
        double km = cm / 100000;
        return String.valueOf(km);
    }


    //KM
    private String kmToInch(double km) {
        double inch = km * 39370.1;
        return String.valueOf(inch);
    }

    private String kmToFoot(double km) {
        double foot = km * 3280.8;
        return String.valueOf(foot);
    }

    private String kmToYard(double km) {
        double yard = km / 0.0009144;
        return String.valueOf(yard);
    }

    private String kmToMile(double km) {
        double mile = km * 0.6213711922;
        return String.valueOf(mile);
    }

    private String kmToCM(double km) {
        double cm = km * 100000;
        return String.valueOf(cm);
    }

}