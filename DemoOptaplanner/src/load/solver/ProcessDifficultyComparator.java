/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package load.solver;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.lang.builder.CompareToBuilder;

public class ProcessDifficultyComparator implements Comparator<load.Beans.Process>,
		Serializable {

	@Override
	public int compare(load.Beans.Process o1, load.Beans.Process o2) {
		return new CompareToBuilder().append(o1.getRequiredCpu(),
				o2.getRequiredCpu()).toComparison();
	}

}
