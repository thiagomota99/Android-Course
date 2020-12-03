# Curso de Android
Esse repositório é destinado para o curso introdutório para desenvolvimento de aplicações móveis em android, utilizando a IDE Android Studio.

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
a criação da view e chamada da mesma. Entretanto, não é a melhor solução, pois podemos além de ser trabalhoso, acaba deixando o código muito mais complexo de entendimento.</br>
Não conseguindo diferenciar o que é views ou lógica da activity. Por isso criamos arquivos estáticos de layout para a criação de views de forma mais intuitiva e respeitando</br>
as boas práticas.

### Criando um layout
 * Na diretório res aperte combinadamente Alt+Insert e procure por **Android Resource Directory**
    * **Directory Name**: layout
    * **Resource type**: layout
    * **Source set**: main
 * Na diretório res aperte combinadamente Alt+Insert e procure por **Android Resource File**
    * **File name**: activity_nomedasuaActivity
</br>

Dado isso, podemos utilizar vários componentes para compor nossa View de forma estática. Posteriormente iremos referencia-la a nossa activity da seguinte forma</br>
Ex: `setContentView(R.layout.activity_main);`</br>
Dessa forma estamos utilizando a Classe **"R"** que tem como objetivo acessar todos os diretórios de resources do projeto, inclusive a **"layout"** que foi criado.</br>
Tendo isso em mente basta referencia-la.
