/*
 Copyright 2015 shizhefei（LuckyJayce）

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package mvc.data;

public class Data1<VALUE1> {

	private VALUE1 value1;

	public Data1() {
		super();
	}

	public Data1(VALUE1 value1) {
		super();
		this.value1 = value1;
	}

	public VALUE1 getValue1() {
		return value1;
	}

	public void setValue1(VALUE1 value1) {
		this.value1 = value1;
	}

}
