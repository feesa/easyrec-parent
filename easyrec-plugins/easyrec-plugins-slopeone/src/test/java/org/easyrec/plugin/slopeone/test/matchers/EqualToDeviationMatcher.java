/*
 * Copyright 2010 Research Studios Austria Forschungsgesellschaft mBH
 *
 * This file is part of easyrec.
 *
 * easyrec is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * easyrec is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with easyrec.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.easyrec.plugin.slopeone.test.matchers;

import org.easyrec.plugin.slopeone.model.Deviation;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;


/**
 * Matcher for deviations checking for normal equality + equality of deviations (normal equality checks for tenantId,
 * itemTypeId, item1id and item2id). <p><b>Company:&nbsp;</b> SAT, Research Studios Austria</p>
 * <p><b>Copyright:&nbsp;</b> (c) 2007</p> <p><b>last modified:</b><br/> $Author: pmarschik $<br/> $Date: 2011-02-11 11:04:49 +0100 (Fr, 11 Feb 2011) $<br/> $Revision: 17656 $</p>
 *
 * @author Patrick Marschik
 */
public class EqualToDeviationMatcher extends TypeSafeMatcher<Deviation> {
    // ------------------------------ FIELDS ------------------------------

    //~ Instance fields ////////////////////////////////////////////////////////////////////////////////////////////////
    private Deviation toCompare;

    // -------------------------- STATIC METHODS --------------------------

    public static Matcher<Deviation> equalToDeviation(Deviation d) {
        return new EqualToDeviationMatcher(d);
    }

    // --------------------------- CONSTRUCTORS ---------------------------

    //~ Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
    public EqualToDeviationMatcher(Deviation toCompare) {
        if (toCompare == null) {
            throw new NullPointerException("toCompare");
        }

        this.toCompare = toCompare;
    }

    // ------------------------ INTERFACE METHODS ------------------------


    // --------------------- Interface SelfDescribing ---------------------

    //~ Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void describeTo(Description description) {
        description.appendValue(toCompare);
    }

    // -------------------------- OTHER METHODS --------------------------

    @Override
    public boolean matchesSafely(Deviation item) {
        return toCompare.equalsWithDeviation(item);
    }
}
