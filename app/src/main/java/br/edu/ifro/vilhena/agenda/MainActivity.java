package br.edu.ifro.vilhena.agenda;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.edu.ifro.vilhena.agenda.dao.ContatoDAO;
import br.edu.ifro.vilhena.agenda.model.Contato;

public class MainActivity extends AppCompatActivity {

    private ListView listaContatos;
    private android.support.design.widget.FloatingActionButton btnFormulario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //String[] contatos = {"Maria", "José", "Tereza"};

        // Mapeando os componentes da activity
        listaContatos = findViewById(R.id.main_lista_contatos);
        btnFormulario = findViewById(R.id.main_abrir_formulario);

//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contatos);

        btnFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        ContatoDAO contatoDAO = new ContatoDAO(this);
        List<Contato> contatos = contatoDAO.listar();

        ArrayAdapter<Contato> adapter =
                new ArrayAdapter<Contato>(this, android.R.layout.simple_list_item_1, contatos);


        listaContatos.setAdapter(adapter);

    }
}
