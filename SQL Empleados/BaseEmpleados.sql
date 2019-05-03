use Empleados;

create table CentroCostos(Codigo int primary key, Descripcion varchar(50));
create table MaestroEmpleados(Nit int primary key, Nombre varchar(45), Direccion varchar(50), Telefono varchar(12),
Ciudad varchar(40), CCosto int, E_Civil varchar(5), F_ingreso date, Cuenta int, foreign key(CCosto) references CentroCostos(Codigo));
create table ConceptosPago(Codigo int primary key, Descripcion varchar(50), Tipo varchar(5), Valor int);
create table ConceptosDescuento(Codigo int primary key, Descripcion varchar(50), Tipo varchar(5), Valor int);
create table Comprobantes(Comprobante varchar(5) primary key, Descripcion varchar(50), Tipo varchar(5), Cuenta int);
create table MovimientosNomina(Nit int, Comprobante varchar(5), FechaLiquidacion date, TotalConcPago int, TotalConcDescto int, TotalPagado int,
foreign key(Nit) references MaestroEmpleados(Nit), foreign key(TotalConcPago) references ConceptosPago(Codigo),
foreign key(TotalConcDescto) references ConceptosDescuento(Codigo), foreign key(Comprobante) references Comprobantes(Comprobante));
