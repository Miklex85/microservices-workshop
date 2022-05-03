#!/bin/bash
set -e

echo "[Workshop] Construyendo imagen del servicio customer-service..."
cd customer-service
docker build -t miklex850/customer-service:2.0 .
echo "[Workshop] Imagen del servicio customer-service construida..."

echo "[Workshop] Construyendo imagen del servicio inventory-service..."
cd ../inventory-service
docker build -t miklex850/inventory-service:2.0 .
echo "[Workshop] Imagen del servicio inventory-service construida..."

echo "[Workshop] Construyendo imagen del servicio reservation-service..."
cd ../reservation-service
docker build -t miklex850/reservation-service:2.0 .
echo "[Workshop] Imagen del servicio reservation-service construida..."

cd ../
echo "[Workshop] Iniciando servicios con docker-compose..."
docker-compose -f docker-compose.yml up -d
echo "[Workshop] Servicios iniciados..."

echo "[Workshop] Limpiando imagenes previas..."
docker image prune -f
echo "[Workshop] Imagenes previas eliminadas"
