package modelManifiesto.bc.vistaNoDML.common;

import oracle.jbo.ViewObject;

public interface LibroDireccionesViewNoDML extends ViewObject {
  void ejecutarByIndice(int indice);
  
  String ejecutarByIndiceReturn(int indice);
}
