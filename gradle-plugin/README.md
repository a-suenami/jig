クラス一覧出力用のタスクjigListをプロジェクトに組み込みます

## 適用方法
現時点ではプラグインリポジトリに公開していないので、`./gradlew gradle-plugin:fatJar`でjarファイルを作り
任意のディレクトリに配置した上で、`build.gradle` に以下を記述

```
buildscript {
     dependencies {
        classpath files('{Jarファイルの配置ディレクトリ}/gradle-jig-plugin-all.jar')
     }
}

apply plugin: 'com.github.irof.Jig'
```

## 設定
```
jigList {
    outputPath = 'build/reports/output.xlsx' //出力ディレクトリ
    outputOmitPrefix= '.+\\.(service|domain\\.(model|basic))\\.' //出力時に省略する接頭辞パターン
}
```
