package com.example.pizzafragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pizzafragment.Repository.ListPizzaFragment;
import com.example.pizzafragment.Repository.ViewPizzaFragment;
import com.example.pizzafragment.model.Pizza;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements ListPizzaFragment.onItemSelectedListener{
    private ListPizzaFragment listPizzaFragment;
    private ViewPizzaFragment viewPizzaFragment;
    private static  final String TAG  = "MainActivity";
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        listPizzaFragment =new ListPizzaFragment();
        ft.add(R.id.content,listPizzaFragment,listPizzaFragment.TAG);
        ft.addToBackStack(null);
        ft.commit();
        }

        Log.d(TAG,"MainActivity -> onCreate()");
        number = new Random().nextInt(101);


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"MainActivity -> onStart()");
        Toast.makeText(this,"Número aleatorio: "+number,Toast.LENGTH_SHORT).show();
    }
    //Esto es otro metodo para guardar la activity
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("number",number);
        Log.d(TAG,"MainActivity -> onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"MainActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"MainActivity -> onDestroy()");
    }

    /**
     * Este metodo corresponde a la interfaz ListPizzaFragment.OnItemSelectedListener
     * Se ejecuta cuando se pulsa sobre un elemento de la lista.
     * @param pizza seleccionada de la lista.
     */
    @Override
    public void onItemSelected(Pizza pizza) {
        //Toast.makeText(this,"Pizza Seleccionada: "+pizza.toString(),Toast.LENGTH_LONG).show();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Bundle bundle = new Bundle();
        //ARg_PIZZA es una constante string que se inicializa en el fragment
        // con la cadena a aañadir en un Bundle
        bundle.putSerializable(ViewPizzaFragment.ARG_PIZZA,pizza);
        //Usamos el metodo factoria newInstance
        viewPizzaFragment = viewPizzaFragment.newInstance(bundle);
        //remplazamos un Fragment por otro
        ft.replace(R.id.content,viewPizzaFragment,viewPizzaFragment.TAG);
        ft.commit();
    }
}