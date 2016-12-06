/**Copyright 2015 Research Studios Austria Forschungsgesellschaft mBH
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
package org.easyrec.plugin.aggregator.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author szavrel
 */
public class AggregatorConfigurationValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(AggregatorConfiguration.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AggregatorConfiguration configuration = (AggregatorConfiguration) target;


        if (configuration.getMaxRulesPerItem() != null && configuration.getMaxRulesPerItem() < 1) {
            errors.rejectValue("maxRulesPerItem", "error.outOfRange", "Valid values for maximum rules per item must be greater than 1!");
        }

    }

}
