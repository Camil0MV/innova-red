# 🗄️ Script de Base de Datos – InnovaRed

Este archivo contiene la estructura (schema) de la base de datos **InnovaRed**, diseñada para gestionar información sobre personas y sus emprendimientos o innovaciones.

---

## 📦 Contenido

El script `estructura_innovared.sql` incluye:

- Creación de la base de datos `innovared_db`
- Tablas:
  - `person`
  - `entrepreneurship`
- Claves primarias y únicas
- Tipos de datos y restricciones básicas

---

## 🚀 Cómo usar el script

### Opción 1: Desde MySQL Workbench

1. Abre **MySQL Workbench**.
2. Conéctate a tu servidor local o remoto.
3. Ve a **File > Open SQL Script** y selecciona `estructura_innovared.sql`.
4. Haz clic en el rayo ⚡ (Ejecutar).

### Opción 2: Desde línea de comandos

```bash
mysql -u tu_usuario -p < ruta/al/archivo/estructura_innovared.sql
