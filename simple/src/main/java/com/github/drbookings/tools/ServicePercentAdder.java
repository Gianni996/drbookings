/*
 * DrBookings
 *
 * Copyright (C) 2016 - 2018 Alexander Kerner
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 */

package com.github.drbookings.tools;

import java.io.File;

import com.github.drbookings.model.ser.BookingBeanSer;
import com.github.drbookings.ser.DataStore;
import com.github.drbookings.ser.XMLStorage;

public class ServicePercentAdder {

	public static void main(final String[] args) throws Exception {

		final File file = new File("/home/alex/bookings.xml");

		final DataStore ds = new XMLStorage().load(file);
		for (final BookingBeanSer bs : ds.getBookingsSer()) {
			if (bs.source.equalsIgnoreCase("booking")) {
				bs.serviceFeePercent = 0.12f;
			}
		}
		new XMLStorage().save(ds, file);
	}
}
