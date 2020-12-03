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

Activitys, fazendo uma analogia de forma bem simplória seriam os **Controllers** em um projeto que trabalha com o **Padrão de Projeto MVC**.
Entretanto as activitys possuem suas particularidades. Geramente, as activitys são compostas por dois elementos essenciais.

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
para a Activity. **Toast** que tem como objetivo mostrar uma mensagem para usuário por um determinado tempo.
