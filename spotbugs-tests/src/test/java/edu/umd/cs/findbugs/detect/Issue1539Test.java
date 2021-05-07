package edu.umd.cs.findbugs.detect;

import edu.umd.cs.findbugs.AbstractIntegrationTest;
import edu.umd.cs.findbugs.test.matcher.BugInstanceMatcher;
import edu.umd.cs.findbugs.test.matcher.BugInstanceMatcherBuilder;
import org.junit.Test;

import static edu.umd.cs.findbugs.test.CountMatcher.containsExactly;
import static org.junit.Assert.assertThat;

public class Issue1539Test extends AbstractIntegrationTest {
    @Test
    public void testInstance() {
        performAnalysis("ghIssues/Issue1539Instance.class");
        BugInstanceMatcher bugTypeMatcher = new BugInstanceMatcherBuilder()
                .bugType("DMI_RANDOM_USED_ONLY_ONCE")
                .build();
        assertThat(getBugCollection(), containsExactly(0, bugTypeMatcher));
    }

    @Test
    public void testStatic() {
        performAnalysis("ghIssues/Issue1539Static.class");
        BugInstanceMatcher bugTypeMatcher = new BugInstanceMatcherBuilder()
                .bugType("DMI_RANDOM_USED_ONLY_ONCE")
                .build();
        assertThat(getBugCollection(), containsExactly(0, bugTypeMatcher));
    }
}