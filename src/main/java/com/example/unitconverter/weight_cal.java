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

public class weight_cal extends AppCompatActivity {

    CardView cv_fromUnit, cv_toUnit, cv_convert;
    RelativeLayout mCLayout;
    String fromUnit = "Kilogram";
    String toUnit = "Kilogram";
    TextView tv_fromUnit, tv_toUnit;
    EditText et_fromUnit, et_toUnit;
    final String[] values = new String[]{
            "Kilogram",
            "Gram",
            "Pound ",
            "Ounce",
            "Ton",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_cal);

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
                            et_toUnit.setText(kilogramToGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(kilogramToPound(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(kilogramToOunce(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(kilogramToTon(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(gramToKiloGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(gramToPound(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(gramToOunce(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(gramToTon(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(poundTOKiloGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(PoundToGRAM(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(PoundToOunce(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(PoundToTon(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(OuncetoKiloGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(OuncetoGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(OuncetoPound(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(OuncetoTon(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(TontoKiloGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(TontoGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(TontoOunce(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(TontoPound(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(tempInput);
                        }
                    }
                }
            }
        });


        cv_toUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(weight_cal.this);
                builder.setTitle("choose Unit");

                final String[] flowers = new String[]{
                        "Kilogram",
                        "Gram",
                        "Pound ",
                        "Ounce",
                        "Ton",

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

                final AlertDialog.Builder builder = new AlertDialog.Builder(weight_cal.this);
                builder.setTitle("choose Unit");

                final String[] flowers = new String[]{
                        "Kilogram",
                        "Gram",
                        "Pound ",
                        "Ounce",
                        "Ton",


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

    //Kilogram

    private String kilogramToGram(double kilogram) {
        double gram = kilogram * 1000;
        return String.valueOf(gram);
    }

    private String kilogramToPound(double kilogram) {
        double pound = kilogram * 2.20462;
        return String.valueOf(pound);
    }

    private String kilogramToOunce(double kilogram) {
        double ounce = kilogram * 35.274;
        return String.valueOf(ounce);
    }

    private String kilogramToTon(double kilogram) {
        double ton = kilogram / 907.2;
        return String.valueOf(ton);
    }


    //Gram
    private String gramToKiloGram(double gram) {
        double kiloGram = gram * 0.001;
        return String.valueOf(kiloGram);
    }

    private String gramToPound(double gram) {
        double pound = gram / 453.6;
        return String.valueOf(pound);
    }

    private String gramToOunce(double gram) {
        double ounce = gram / 28.35;
        return String.valueOf(ounce);
    }

    private String gramToTon(double gram) {
        double ton = gram / 907200;
        return String.valueOf(ton);
    }


    //Pound
    private String poundTOKiloGram(double pound) {
        double kiloGram = pound * 0.453592;
        return String.valueOf(kiloGram);
    }

    private String PoundToGRAM(double Pound) {
        double Gram = Pound * 453.59237;
        return String.valueOf(Gram);
    }

    private String PoundToOunce(double pound) {
        double ounce = pound * 16;
        return String.valueOf(ounce);
    }

    private String PoundToTon(double pound) {
        double ton = pound / 2000;
        return String.valueOf(ton);
    }


    //Ounce
    private String OuncetoKiloGram(double ounce) {
        double kiloGram = ounce / 0.2834952;
        return String.valueOf(kiloGram);
    }

    private String OuncetoGram(double ounce) {
        double gram = ounce * 28.3495;
        return String.valueOf(gram);
    }

    private String OuncetoPound(double ounce) {
        double pound = ounce / 16;
        return String.valueOf(pound);
    }

    private String OuncetoTon(double ounce) {
        double ton = ounce / 32000;
        return String.valueOf(ton);
    }


    //Ton
    private String TontoKiloGram(double ton) {
        double kiloGram = ton * 907.185;
        return String.valueOf(kiloGram);
    }

    private String TontoGram(double ton) {
        double gram = ton * 907184.74;
        return String.valueOf(gram);
    }

    private String TontoPound(double ton) {
        double pound = ton * 2000;
        return String.valueOf(pound);
    }

    private String TontoOunce(double ton) {
        double ounce = ton / 32000;
        return String.valueOf(ounce);
    }
}