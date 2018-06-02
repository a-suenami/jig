package org.dddjava.jig.domain.model.boolquerymethod;

import org.dddjava.jig.domain.basic.report.ConvertibleItem;
import org.dddjava.jig.domain.basic.report.Report;
import org.dddjava.jig.domain.model.identifier.type.TypeIdentifierFormatter;
import org.dddjava.jig.domain.model.japanese.JapaneseName;
import org.dddjava.jig.domain.model.networks.DependencyNumber;

import java.util.List;
import java.util.function.Function;

/**
 * 真偽値を返すモデルのメソッドレポート
 */
public class BoolQueryModelMethodReport {

    /**
     * レポート項目
     */
    private enum Items implements ConvertibleItem<Row> {
        メソッド(Row::メソッド名),
        メソッド和名(Row::メソッド和名),
        クラス名(Row::クラス名),
        クラス和名(Row::クラス和名),
        使用箇所数(Row::使用箇所数),
        使用箇所(Row::使用箇所);

        Function<Row, String> func;

        Items(Function<Row, String> func) {
            this.func = func;
        }

        @Override
        public String convert(Row row) {
            return func.apply(row);
        }
    }

    private final List<Row> list;

    public BoolQueryModelMethodReport(List<Row> list) {
        this.list = list;
    }

    public Report<?> toReport() {
        return new Report<>("真偽値を返すメソッド", list, Items.values());
    }

    public static class Row {
        BoolQueryModelMethodAngle angle;
        JapaneseName japaneseMethodName;
        JapaneseName japaneseClassName;
        TypeIdentifierFormatter identifierFormatter;

        public Row(BoolQueryModelMethodAngle angle, JapaneseName japaneseMethodName, JapaneseName japaneseClassName, TypeIdentifierFormatter identifierFormatter) {
            this.angle = angle;
            this.japaneseMethodName = japaneseMethodName;
            this.japaneseClassName = japaneseClassName;
            this.identifierFormatter = identifierFormatter;
        }

        String クラス名() {
            return angle.declaringTypeIdentifier().format(identifierFormatter);
        }

        String クラス和名() {
            return japaneseClassName.summarySentence();
        }

        String メソッド名() {
            return angle.method().asSignatureSimpleText();
        }

        String メソッド和名() {
            return japaneseMethodName.summarySentence();
        }

        String 使用箇所() {
            return angle.userTypeIdentifiers().asSimpleText();
        }

        String 使用箇所数() {
            return new DependencyNumber(angle.userTypeIdentifiers().list().size()).asText();
        }
    }
}