/* TestWellKnownService.cs
 *
 * Project: IIOP.NET
 * IntegrationTests
 *
 * WHEN      RESPONSIBLE
 * 16.01.05  Dominic Ullmann (DUL), dominic.ullmann -at- elca.ch
 *
 * Copyright 2003 ELCA Informatique SA
 * Av. de la Harpe 22-24, 1000 Lausanne 13, Switzerland
 * www.elca.ch
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
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */


using System;
using Ch.Elca.Iiop.Idl;

namespace Ch.Elca.Iiop.IntegrationTests {

    /// <summary>will be published as well known single call remoting object or well known singleton remoting object</summary>
    [SupportedInterfaceAttribute(typeof(ISimpleTestInterface))]
    public class TestWellKnownService : MarshalByRefObject, ISimpleTestInterface {

        private const Int32 INITIAL_VAL = 2;

        private System.Int32 m_val = INITIAL_VAL;

        /// <summary>used to check, if values are conserved or not</summary>
        public System.Int32 TestValue {
            get {
                return m_val;
            }
            set {
                m_val = value;
            }
        }

        public System.Int32 InitialValue {
            get {
                return INITIAL_VAL;
            }
        }

        /// <summary>used to check, that a call works as expected</summary>
        public Int32 Add(Int32 arg1, Int32 arg2) {
            return arg1 + arg2;
        }

    }

}