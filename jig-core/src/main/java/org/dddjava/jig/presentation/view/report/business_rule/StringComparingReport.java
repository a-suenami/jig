package org.dddjava.jig.presentation.view.report.business_rule;

import org.dddjava.jig.domain.model.jigloaded.richmethod.Method;
import org.dddjava.jig.presentation.view.report.ReportItem;
import org.dddjava.jig.presentation.view.report.ReportItemFor;
import org.dddjava.jig.presentation.view.report.ReportTitle;

@ReportTitle("文字列比較箇所")
public class StringComparingReport {

    private Method method;

    public StringComparingReport(Method method) {
        this.method = method;
    }

    @ReportItemFor(ReportItem.クラス名)
    @ReportItemFor(ReportItem.メソッドシグネチャ)
    public Method method() {
        return method;
    }
}
