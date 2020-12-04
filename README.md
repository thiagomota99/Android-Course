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
  `    <application
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
      </application>`
      
## Aula 2
Durante a aula dois foi abordado o **Ciclo de Vida do Android** que é dado inicialmente pelo método `onCreate()`.</br> 
O mesmo é responsável por executar os comportamentos da activity. Após a crição do método, foi adicionado um novo comportamento</br>
para a Activity. **Toast** que tem como objetivo mostrar uma mensagem para o usuário por um determinado período de tempo.</br></br>


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
   Procure por **ListView** na paleta de componentes</br>
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
    **Obs:** AdapterViews são tipos de Views que possum a possibilidade de exibir dados de forma dinâmica. Como</br>
             exemplo a ListView. Podemos incrementa-la conforme a nossa necessidade, sem definir um número fixo</br>
             de elementos para serem exibidos.
</br>
* Botão para adicionar novo aluno;</br>
    Procure por **FloatingActionButton** na paleta de componentes










