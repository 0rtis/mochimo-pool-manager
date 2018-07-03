/*******************************************************************************
 * Copyright (C) 2018 Ortis (cao.ortis.org@gmail.com)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/

package org.ortis.mochimo.farm_manager.farm.miner;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.ortis.mochimo.farm_manager.farm.FieldConfig;

public class MinerConfig
{

	public final static String MINER_ID_LABEL = "id";

	private final String id;
	private final Map<String, FieldConfig> config;
	private final Map<String, FieldConfig> roConfig;

	public MinerConfig(final Map<String, String> config)
	{

		this.config = new LinkedHashMap<>();
		FieldConfig.parseConfig(config, this.config);
		this.roConfig = Collections.unmodifiableMap(this.config);

		final FieldConfig field = this.get(MINER_ID_LABEL);
		if (field == null)
			throw new IllegalArgumentException(MINER_ID_LABEL + " field not found");
		if (field.isEncrytped())
			throw new IllegalArgumentException(MINER_ID_LABEL + " field is encrypted");

		if (field.getValue() == null)
			throw new IllegalArgumentException(MINER_ID_LABEL + " field is null");
		this.id = field.getValue();
	}

	public String getId()
	{
		return id;
	}

	public Map<String, FieldConfig> getFields()
	{
		return this.roConfig;
	}

	public FieldConfig get(final String name)
	{
		return this.config.get(name);
	}

	@Override
	public String toString()
	{
		return this.config.toString();
	}

	public static boolean isIdField(final String name)
	{
		return MINER_ID_LABEL.equals(name);
	}

}
