/*
 * Distributed as part of Scalala, a linear algebra library.
 *
 * Copyright (C) 2008- Daniel Ramage
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110 USA
 */
package scalala;
package tensor;
package dense;

import org.scalacheck._
import org.scalatest._;
import org.scalatest.junit._;
import org.scalatest.prop._;
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class DenseMatrixTest extends FunSuite with Checkers {

  test("Slicing") {
    val matrix = DenseMatrix(2,3)(0);
    matrix((0 to 1), (1 to 2)) := 1;
    matrix((0 to 1), (0 to 1)) += 4;

    assert(matrix.data.toList === List(4, 4, 5, 5, 1, 1));
  }

  test("Transpose") {
    val matrix = DenseMatrix(2,3)(1,2,0,3,0,0);
    assert(matrix.transpose === DenseMatrix(3,2)(1,0,0,2,3,0));
    assert(matrix.transpose.isInstanceOf[Matrix]);
  }
}
