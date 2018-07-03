/*******************************************************************************
 * Copyright (C) 2018 Ortis (cao.ortis.org@gmail.com)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package org.ortis.mochimo.farm_manager.command_lines;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.ortis.mochimo.farm_manager.log.CLILogHandler;

/**
 * Utility class for command_lines package
 * 
 * @author Ortis <br>
 *         2018 Jul 03 9:23:37 PM <br>
 */
public class CommandLines
{
	private static final Logger CLI_LOG = Logger.getLogger("cli");
	static
	{
		CLI_LOG.setUseParentHandlers(false);
		CLI_LOG.setLevel(Level.ALL);
		CLI_LOG.addHandler(new CLILogHandler());
	}

	public static Logger getLog()
	{
		return CLI_LOG;
	}
}
