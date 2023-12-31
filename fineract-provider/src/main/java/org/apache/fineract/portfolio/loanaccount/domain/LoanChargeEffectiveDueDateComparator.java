/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.portfolio.loanaccount.domain;

import java.util.Comparator;

/**
 * Sort loan charges by effective due date
 *
 * Null values go to the end
 */
public final class LoanChargeEffectiveDueDateComparator implements Comparator<LoanCharge> {

    public static final LoanChargeEffectiveDueDateComparator INSTANCE = new LoanChargeEffectiveDueDateComparator();

    private LoanChargeEffectiveDueDateComparator() {}

    @Override
    public int compare(final LoanCharge o1, final LoanCharge o2) {
        if (o1.getEffectiveDueDate() == null && o2.getEffectiveDueDate() != null) {
            return 1;
        } else if (o1.getEffectiveDueDate() == null) {
            return 0;
        } else if (o2.getEffectiveDueDate() == null) {
            return -1;
        }
        return o1.getEffectiveDueDate().compareTo(o2.getEffectiveDueDate());
    }
}
