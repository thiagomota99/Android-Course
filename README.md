# Curso de Android
Esse repositório é destinado para o curso introdutório para desenvolvimento de aplicações móveis em android, utilizando a IDE Android Studio **3.2.1**.

## Primeiros Passos
1. Baixar a versão deseja do [Android Studio](https://developer.android.com/studio/archive)
2. Criar e configurar um [projeto android](https://developer.android.com/training/basics/firstapp/creating-project)
3. [Criar um emulador](https://developer.android.com/training/basics/firstapp/running-app) para execução dos apps desenvolvidos

***

# Resumo das aulas
## Aula 1 - *ListaDeAlunos*
Durante a primeira aula foi criado uma activity vazia para o projeto. Onde a mesma foi registrada e definida como uma activity principal. 
Dado isso, será executada e exibida assim que o programa for aberto.

Activities, fazendo uma analogia de forma bem simplória seriam os **Controllers** em um projeto que trabalha com o **Padrão de Projeto MVC**.
Entretanto as activities possuem suas particularidades. Geramente, as activities são compostas por dois elementos essenciais.

- **Views**: É tudo aquilo que é visual e estático. Como exemplos são os botões, textos, layout...
- **Lógica**: É ação sobre as views. O click no botão para somar dois número é um exemplo.

### Criação da Activity
 - É criado uma classe java vazia dentro do diretório de produção do projeto, onde a mesma irá extender a classe Activity.<br/>
Ex: `public class MainActivity extends Activity`
 
 - No arquivo *AndroidManifest.xml* é feito o registro da activity, categorizando como principal e lançando a mesma.<br/>
 ```xml
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme" >
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>
```

***

## Aula 2
Durante a aula dois foi abordado o **Ciclo de Vida do Android** que é dado inicialmente pelo método `onCreate()`.</br> 
O mesmo é responsável por executar os comportamentos da activity. Após a crição do método, foi adicionado um novo comportamento</br>
para a Activity. **Toast** que tem como objetivo mostrar uma mensagem para o usuário por um determinado período de tempo.</br></br>

***

## Aula 3
Durante a aula três foi abordado a criação e a configuração de views para as activities. Onde foi primeiro utilizado o código java para</br>
a criação da view e chamada da mesma. Entretanto, não é a melhor solução, pois além de ser trabalhoso implementar via java algumas views, acaba deixando o código muito mais complexo de entendimento.</br>
Não conseguindo diferenciar o que é views ou lógica da activity. Por isso criamos arquivos estáticos de layout para a criação de views de forma mais intuitiva e respeitando
as boas práticas.

### Criando um layout
 * No diretório res aperte combinadamente Alt+Insert e procure por **Android Resource Directory**
    * **Directory Name**: layout
    * **Resource type**: layout
    * **Source set**: main
 * No diretório res aperte combinadamente Alt+Insert e procure por **Android Resource File**
    * **File name**: activity_nomedasuaActivity
</br>

Dado isso, podemos utilizar vários componentes para compor nossa View de forma estática. Posteriormente iremos referencia-la a nossa activity da seguinte forma</br>
Ex: `setContentView(R.layout.activity_main);`</br>
Dessa forma estamos utilizando a Classe **"R"** que tem como objetivo acessar todos os diretórios de resources do projeto, inclusive a **"layout"** que foi criado.</br>
Tendo isso em mente basta referencia-la.

### Implementando Layout Proposto - Lista de Alunos
* App bar com título Lista de Alunos;</br>
   `setTitle("Lista de Alunos")`</br>
* Lista de alunos - ListView;</br>
   Procure por **ListView** na paleta de componentes adcione ela ao layout, e altere seu id</br>
    ```Java
        /*Settando o título da App Bar*/
        setTitle("Lista de Alunos");

        /*Criando uma lista de Strings com três índices*/
        List<String> listaAlunos = new ArrayList<>(Arrays.asList("Maria","Thiago","Francivaldo"));

        /*findViewById() é o método que nos permite acessar a classe R e pegar o id da view ListView que criamos*/
        ListView listaViewAlunos = findViewById(R.id.activity_main_lista_de_alunos);
        

        /*Como a ListView não possui um método add para adicionarmos e exibir a lista que criamos
          utilizamos o setAdapter. Ele é um intermediário utilizado para pegar os dados da lista
          e redenriza-los em uma view desejada, no caso a ListView. Para isso, ele espera como parâmetro a
          implementação de uma interface do tipo ListAdapter.
          Usaremos o ArrayAdapter que é um dos adapters mais comuns para a exibição
          de uma simples lista. A sobrecarga utulizada espera 3 argumentos, sendo o primeiro
          o contexto que será nossa activity, um resource de layout que possua apenas uma view do tipo TextView
          e por fim, nossa lista de elementos que desejamos exibir na ListView.
        */
        listaViewAlunos.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaAlunos));

    ```
    **AdapterViews**: São tipos de Views que possum a possibilidade de exibir dados de forma dinâmica. Como</br>
                      exemplo a ListView. Podemos incrementa-la conforme a nossa necessidade, sem definir um número fixo</br>
                      de elementos para serem exibidos.</br>

* Botão para adicionar novo aluno;</br>
    Procure por **FloatingActionButton** na paleta de componentes. Adicione a biblioteca do FloatingActionButton, caso necessário.</br>
    Converta o tipo de Layout de **LinearLayout** para **RelativeLayout**</br>

    **ViewGroups** São views que geralmente tem como objetivo serem os elementos raízes para organizar outras views dentro da mesma.</br>
                   O RelativeLayout, LinearLayout são exemplos disso. Entretanto, a forma como organizam os elementos irá variar.</br>
                   Enquanto o Linear, orienta suas views filhas de forma linear e vertical (uma embaixo da outra) a Relative aborda uma</br>
                   estrutura de sobreposição de elementos, dando mais liberdade de movimentaçãa quanto a posição das views no layout.
***

## Aula 4 - Código Fonte do Layout
O Layout possui uma abar para mexermos diretamente com código fonte das Views. É necessário o conhecimento do source das views, até mesmo</br>
para alterar algumas propriedades de forma mais personalizada. Veja um exemplo logo abaixo:</br>
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/activity_main_fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentEnd="true"
        android:layout_alignParentBottom="true"
        android:layout_marginEnd="25dp"
        android:layout_marginBottom="20dp"
        android:clickable="true" />

    <ListView
        android:id="@+id/activity_main_lista_de_alunos"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</RelativeLayout>
```
</br>Algumas propriedades de Views são obrigatórias como a `android:layout_width="match_parent"` e `android:layout_height="match_parent">`</br>
Dado isso elas possuem alguns valores que podem ser atribuídos como *match_parent* e i *wrap_content*</br>

* **match_parent**: Terá como referência a largura ou altura do elemento "pai" daquela view.
* **wrap_content**: Terá como referência a largura e altura do conteúdo interno. Ou seja, se ajustará conforme o tamanho do conteúdo.</br>

Outros atributos...</br>
* `android:layout_marginEnd="25dp"`: Define a margem final de uma view em relação ao elemento pai.
* `android:layout_marginBottom="20dp"`: Define a margem inferior de uma view em relação ao elemento pai.</br>

**OBS**</br>
    Normalmente utilizamos a unidade de medidade "dp" para atribuirmos as nossas views. Pois a mesma tem como objetivo manter o mesmo aspecto visual, em diferentes dispositivos.</br>
    Para que em dispostivos com displays menores ou maiores o layout não sofra grandes distorções.

***

## Aula 5 - Imagens e AppCompatActivity
Foi abordado durante a adição de ícones ao projeto. Para implementa-los dentro de views como o FloatingActionButton, desta forma dar mais sentido quanto as ações que um view realiza.</br>
Já o AppComatActivity é uma classe que extende de Activity, entretanto da suporte para versões do android mais antigas. Ou seja, podemos utilizar features de versões mais recentes do</br>
android em versões antigas com a extensão dessa classe em nossas Activities.

***

## Aula 6 - Projeto Final


### Passos a serem realizados
1. Criar um projeto Android
2. Criar duas Activities: ListaDeAlunosActivity e NovoAlunoActivity
3. Adicionar a Activity ListaDeAlunos uma ListView e FloatingActionButton
4. Adicionar a Activity NovoAluno 3 EditText e 1 Button
5. Pegar os valores dos campos de EditText
6. Criar evento do Button

Para capturar eventos de nossas views devemos utlizar para nossas views utilizamos o Listerners que são interfaces</br>
para capturar o evento de alguma view. No caso, o click do botão.</br>
Ex:
```Java
        //Primeiro pegamos a referência do botão.
        Button btnSalvar = findViewById(R.id.activity_novo_aluno_botao_salvar);

        //Pegando as referências dos campos nome,telefone e email da view EditText
        final EditText campoNome = findViewById(R.id.activity_novo_aluno_campo_nome);
        final EditText campoTelefone = findViewById(R.id.activity_novo_aluno_campo_telefone);
        final EditText campoEmail = findViewById(R.id.activity_novo_aluno_campo_email);

        /*Iremos utilizar o método setOnclickListener para capturar o evento de click no botão
          iremos relizar a implementação da classe que é uma interface de todos os componentes que herdam de View
        */
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pegando os valores dos campos e atribuindo as variáveis locais
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                Aluno alunoCriado = new Aluno(nome,telefone,email);
                alunoDAO.salvar(alunoCriado);

                //Inializnado outra activity
                startActivity(new Intent(NovoAlunoActivity.this, ListaAlunosActivity.class));
            }
        });
````

7. Criar diretório e uma classe de modelo chamada Aluno para receber os valores das variáveis: nome, telefone e email
```Java
public class Aluno {
    private final String nome;
    private final String telefone;
    private final String email;

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

}
```
8. Criar diretório para uma classe de DAO chamada AlunoDAO para relizar ações de "persitência" de dados, como os métodos salvar e listar.
```Java
public class AlunoDAO {
    private final static List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> todos() {

        return new ArrayList<>(alunos);
    }
}
```
</br></br>


# CRUD - LISTA DE ALAUNOS.
Está parte do projeto tem como intuito a criação de um crud para o app Lista de Alunos.</br>
Desta forma, estaremos implementando uma maneira de Criar(C), carregar(R), alterar(U) e deletar(D) os dados.</br>
Para que isso funcione, iremos utilizar novos [**Listeners de Evento**](https://developer.android.com/guide/topics/ui/ui-events?hl=pt-br)</br></br>

## Criar (C)
Primeiramente foi criado uma activity com o nome de **NovoAlunoActivity** que tem como objetivo implementar a lógica das views por ela controladas.</br>
Foram utilizados 4 views, sendo elas:
* LinearLayout : Organização das views filhas (TextView, Button)
* TextView : Campos para preenchimento de campo
* Button : Criação de botões para o disparo de eventos
* ScrollView : View utilizada para implementar barra de rolagem.

<br>

Foi criado um arquivo estático(xml) para implementar as views

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">


        <EditText
            android:id="@+id/activity_novo_aluno_campo_nome"
            android:hint="Nome"
            android:layout_margin="8dp"
            android:inputType="textCapWords"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <EditText
            android:id="@+id/activity_novo_aluno_campo_telefone"
            android:hint="Telefone"
            android:layout_margin="8dp"
            android:inputType="number"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <EditText
            android:id="@+id/activity_novo_aluno_campo_email"
            android:hint="E-mail"
            android:layout_margin="8dp"
            android:inputType="textEmailAddress"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <Button
            android:id="@+id/activity_novo_aluno_botao_salvar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="8dp"
            android:text="Salvar"/>

    </LinearLayout>
</ScrollView>
```

Para a implementação da activity foram utilizados os métodos:
* onCreate() : Método do ciclo de vida do android. Executado assim que a activity é criada.
* onCreateOptionsMenu() : Método responsável por criar os itens do menu na appbar do aplicativo. O mesmo será executado automaticamente pelo android, no momento da criação da activity.
* onOptionsItemSelected() : Método responsável por capturar o click sobre o item do menu
* configuraBotaoSalvar() : Método responsável por inicializar o listener de evento do botão "Salvar".
* inicializacaoDosCampos() : Método responsável por inicializar os campos TextView
* preenchaAluno() : Método responsável por setar os valores dos campos no objeto.
* onClick() : Método responsável por capturar o cick do botão "Salvar" e executar seu comportamento.
* definirAcao() Método responsável por definir qual tipo de ação será realizado criação/edição e finalização/destruição da activity.





