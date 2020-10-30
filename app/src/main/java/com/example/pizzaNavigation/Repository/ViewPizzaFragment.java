package com.example.pizzafragment.Repository;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pizzafragment.R;
import com.example.pizzafragment.model.Pizza;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewPizzaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPizzaFragment extends Fragment {


    public static final String ARG_PIZZA = "pizza";
    public static final String TAG = "ViewPizzaFragment";
    private TextView tvName;
    private TextView  tvDescription;
    private int number;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated();
        tvName = view.findViewById((R.id.tvName));
        tvDescription = view.findViewById((R.id.tvDescription));
        //Se recoge los argumentos, es decir, el objeto Bundle
        Pizza pizza = (Pizza)(getArguments().getSerializable(ARG_PIZZA));
        //Se inicializa la vista con los datos de la pizza
        tvName.setText(pizza.getName());
        tvDescription.setText(pizza.getDescription());
    }

    public ViewPizzaFragment() {
        // Required empty public constructor
    }

    /**
     * Usamos este metodo factoria para crear una instancia
     * de este fragment que recibe com parametro
     * un objeto bundle
     *
     * @param bundle Contiene los argumentos del Fragment

     * @return Una instancia del Fragmento ViewPizzaFragment
     */
    // TODO: Rename and change types and number of parameters
    public static ViewPizzaFragment newInstance(Bundle bundle) {
        ViewPizzaFragment fragment = new ViewPizzaFragment();
        if (bundle != null)
            fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true); //Para guardar el estado de instancia
        Log.d(TAG,"ViewPizzaFragment -> onCreate()");
        number = new Random().nextInt(101);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pizza, container, false);
    }


}