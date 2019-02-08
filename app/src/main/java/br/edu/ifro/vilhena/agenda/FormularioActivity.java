package br.edu.ifro.vilhena.agenda;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifro.vilhena.agenda.dao.ContatoDAO;
import br.edu.ifro.vilhena.agenda.model.Contato;

public class FormularioActivity extends AppCompatActivity {

    private Button botao;
    private EditText formularioNome;
    private EditText formularioEndereco;
    private EditText formularioEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        // Mapeando os componentes
        botao = findViewById(R.id.formulario_botao);
        formularioNome = findViewById(R.id.formulario_nome);
        formularioEmail = findViewById(R.id.formulario_email);
        formularioEndereco = findViewById(R.id.formulario_endereco);

        // Ao clicar no botão
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Criando um Contato
                Contato contato = new Contato();
                contato.setNome(formularioNome.getText().toString());
                contato.setEmail(formularioEmail.getText().toString());
                contato.setEndereco(formularioEndereco.getText().toString());

                ContatoDAO contatoDAO = new ContatoDAO(FormularioActivity.this);
                contatoDAO.inserir(contato);
                contatoDAO.close();

                //Snackbar.make(findViewById(R.id.formulario), "Contato" + contato.getNome() + " salvo com sucesso!", Snackbar.LENGTH_LONG).show();
                // Mostra a mensagem
                Toast.makeText(FormularioActivity.this, "Contato salvo", Toast.LENGTH_LONG).show();

                // Destrói a activity
                finish();
            }
        });
    }


}
